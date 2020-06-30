package market.mapper;

import market.Bean.Users;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UsersMapper {

    //查询所有用户
    @Select("<script>select * from smbms_user where 1=1"
            +"<if test='name!=null'> and name like concat('%',#{name},'%') </if>"
            +"</script>")
    public List<Users> findusers(String name);

    //查询所有用户的数量
    @Select("<script>select count(*) from smbms_user where 1=1"
            +"<if test='name!=null'> and name like concat('%',#{name},'%') </if>"
            +"</script>")
    public int findcount(String name);

    //根据账号查询用户
    @Select("select * from smbms_user where userName=#{userName}")
    public Users findbyuserName(String userName);

    //根据id查询用户
    @Select("select * from smbms_user where id=#{id}")
    public Users findbyid(int id);

    //根据账号密码查询用户
    @Select("select * from smbms_user where userName=#{userName} and userPassword=#{userPassword}")
    public Users findbynamepwd(@Param("userName")String userName,@Param("userPassword")String userPassword);

    //保存用户
    @Insert("insert into smbms_user values(null,#{name},#{userName},#{userPassword},#{gender},#{birthday},#{phone},#{address},#{userType},#{createdBy},#{creationDate},null,null)")
    public void save(Users users);

    //修改用户
    @Update("update smbms_user set name=#{name},gender=#{gender},birthday=#{birthday},phone=#{phone},address=#{address},userType=#{userType},modifyBy=#{modifyBy},modifyDate=#{modifyDate} where id=#{id}")
    public void update(Users users);

    //删除用户
    @Delete("delete from smbms_user where id=#{id}")
    public void delete(int id);

    //修改密码
    @Update("update smbms_user set userPassword=#{userPassword} where id=#{id}")
    public void updatepsw(@Param("id")int id,@Param("userPassword")String userPassword);

    //模糊查询
    @Select("<script>select * from smbms_user where 1=1"
            +"<if test='name!=null'> and name like concat('%',#{name},'%') </if>"
            +"</script>")
    public List<Users> search(String name);
}
