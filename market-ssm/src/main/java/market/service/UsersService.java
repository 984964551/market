package market.service;



import market.Bean.PageBean;
import market.Bean.Users;

import java.util.List;

public interface UsersService {

    public PageBean findbypage(int currentpage,String name);

    public Users findbyuserName(String userName);

    public Users findbyid(int id);

    public Users findbynamepwd(String userName,String userPassword);

    public List<Users> search(String name);

    public void updatepsw(int id,String userPassword);

    public void save(Users users);

    public void delete(int id);

    public void update(Users users);
}
