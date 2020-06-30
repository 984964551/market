package market.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import market.Bean.PageBean;
import market.Bean.Users;
import market.mapper.UsersMapper;
import market.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public PageBean findbypage(int currentpage,String name) {
        int pagesize=5;
        PageHelper.startPage(currentpage,pagesize );
        List<Users> list = usersMapper.findusers(name);
        for (int i = 0; i <list.size() ; i++) {
            Users user = list.get(i);
            user.setRole(getrole(user.getUserType()));
            user.setSex(getsex(user.getGender()));
            user.setAge(getAgeByBirthday(user.getBirthday()));
        }
        PageBean<Users> pb = new PageBean<>();
        int totalcount = usersMapper.findcount(name);
        pb.setList(list);
        pb.setTotalCount(totalcount);
        pb.setCurrentPage(currentpage);
        pb.setPageSize(5);
        int totalpage=(totalcount%pagesize) == 0 ? (totalcount/pagesize) : (totalcount/pagesize)+1;
        pb.setTotalPage(totalpage);
        return pb;
    }

    @Override
    public Users findbyuserName(String userName) {
        return usersMapper.findbyuserName(userName);
    }

    @Override
    public Users findbyid(int id) {
        Users user = usersMapper.findbyid(id);
        if(user!=null) {
            user.setRole(getrole(user.getUserType()));
            user.setSex(getsex(user.getGender()));
            user.setAge(getAgeByBirthday(user.getBirthday()));
            //birthday的Date格式转换为String格式
            java.util.Date birthday =user.getBirthday();
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            user.setBirthdaystr(sdf.format(birthday));
        }
        return user;
    }

    @Override
    public Users findbynamepwd(String userName, String userPassword) {
        Users user = usersMapper.findbynamepwd(userName, userPassword);
        if(user!=null){
            user.setRole(getrole(user.getGender()));
            user.setSex(getsex(user.getGender()));
            user.setAge(getAgeByBirthday(user.getBirthday()));
        }
        return user;
    }

    @Override
    public List<Users> search(String name) {
        List<Users> list = usersMapper.search(name);
        for (int i = 0; i <list.size() ; i++) {
            Users user = list.get(i);
            if (user!=null) {
                user.setRole(getrole(user.getGender()));
                user.setSex(getsex(user.getGender()));
                user.setAge(getAgeByBirthday(user.getBirthday()));
            }
        }
        return list;
    }

    @Override
    public void updatepsw(int id, String userPassword) {
        usersMapper.updatepsw(id, userPassword);
    }

    @Override
    public void save(Users users) {
        users.setCreationDate(new java.util.Date());
        usersMapper.save(users);
    }

    @Override
    public void delete(int id) {
        usersMapper.delete(id);
    }

    @Override
    public void update(Users users) {
        users.setModifyDate(new java.util.Date());
        usersMapper.update(users);
    }


    public static String getrole(int num){
        if (num==1){
            return "系统管理员";
        }else if (num==2){
            return "经理";
        }else {
            return "普通员工";
        }
    }
    public static String getsex(int num){
        if (num==1){
            return "男";
        }else {
            return "女";
        }
    }
    public static int getAgeByBirthday(Date birthday) {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthday)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                // monthNow==monthBirth
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                // monthNow>monthBirth
                age--;
            }
        }
        return age;
    }

}
