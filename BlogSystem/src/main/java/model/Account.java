package model;
//用于登录时，Jackson获取账号密码的载体
public class Account {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
