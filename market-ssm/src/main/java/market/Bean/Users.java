package market.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private Integer id;
    private String name;
    private String userName;
    private String userPassword;
    private int gender;
    private String sex; //性别
    private java.sql.Date birthday;
    private String birthdaystr; //String类型数据
    private int age; //年龄
    private String phone;
    private String address;
    private int userType;
    private String role; //权限
    private int createdBy;
    private Date creationDate;
    private int modifyBy;
    private Date modifyDate;
}
