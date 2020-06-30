package market.controller;

import market.Bean.PageBean;
import market.Bean.Users;
import market.Bean.Result;
import market.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    UsersService usersService;

    //分页条件查询所有用户
    @RequestMapping("/findbypage")
    @ResponseBody
    public PageBean findbypage(Integer currentpage,String name){
        if (currentpage==null){
            currentpage=1;
        }
        PageBean info = usersService.findbypage(currentpage,name);
        return info;
    }

    //按条件查询用户
    @RequestMapping("/search")
    @ResponseBody
    public List<Users> search(String name){
        List<Users> list = usersService.search(name);
        return list;
    }

    //根据id查询用户
    @RequestMapping("/findById")
    @ResponseBody
    public Users findById(Integer id){
        Users user = usersService.findbyid(id);
        return user;
    }

    //欢迎用户名
    @RequestMapping("/welcome")
    @ResponseBody
    public Users  welcome(HttpServletRequest request){
        Users user = (Users) request.getSession().getAttribute("user");
        return user;
    }

    //用户退出
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return null;
    }

    //保存用户
    @RequestMapping("/save")
    @ResponseBody
    public Boolean save(Users users,HttpServletRequest request){
        System.out.println(users);
        Users sessionuser = (Users) request.getSession().getAttribute("user");
        users.setCreatedBy(sessionuser.getId());
        Users olduser = usersService.findbyuserName(users.getUserName());
        if (olduser==null){
            usersService.save(users);
            return true;
        }else {
            return false;
        }
    }

    //修改用户
    @RequestMapping("/update")
    @ResponseBody
    public Boolean update(Users users,HttpServletRequest request){
        Users sessionuser = (Users) request.getSession().getAttribute("user");
        users.setModifyBy(sessionuser.getId());
        usersService.update(users);
        return true;
    }

    //更新密码
    @RequestMapping("/updatePsw")
    @ResponseBody
    public Boolean updatePsw(@RequestParam("oldPwd") String oldPwd,@RequestParam("newPwd") String newPwd,HttpServletRequest request){
        Users user = (Users) request.getSession().getAttribute("user");
        if (user.getUserPassword().equals(oldPwd)){
            usersService.updatepsw(user.getId(),newPwd );
            return true;
        }else {
            return false;
        }
    }

    //根据id删除用户
    @RequestMapping("/delById")
    @ResponseBody
    public Boolean delById(@RequestParam("id") int id){
        usersService.delete(id);
        return true;
    }

    //重置默认密码
    @RequestMapping("/defaultPwd")
    @ResponseBody
    public Boolean defaultPsw(@RequestParam("id") int id){
        usersService.updatepsw(id,"123456" );
        return true;
    }

    //用户登录验证
    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestParam("userName") String userName ,@RequestParam("userPassword") String userPassword, HttpServletRequest request){
        Users user = usersService.findbynamepwd(userName,userPassword );
        Result result = new Result();
        if (user!=null){
            if ("系统管理员".equals(user.getRole()) || "经理".equals(user.getRole())){
                request.getSession().setAttribute("user",user );
                result.setData(user);
                result.setFlag(true);
            }else {
                result.setFlag(false);
                result.setMsg("您没有进入系统的权限");
            }
        }else {
            result.setFlag(false);
            result.setMsg("用户名或密码错误");
        }
        return result;
    }
}
