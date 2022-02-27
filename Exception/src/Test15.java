class NameException extends RuntimeException {
    public NameException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
class PasswordException extends RuntimeException {
    public PasswordException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
public class Test15 {
    private static String userName = "未见花闻";
    private static String password = "5201314";
    public static void login(String userName, String password) throws NameException, PasswordException{
        if (!Test15.userName.equals(userName)) {
            throw new NameException("用户名不存在！");
        }
        if (!Test15.password.equals(password)) {
            throw new PasswordException("密码错误！");
        }
        System.out.println("登陆成功");
    }
    public static void main(String[] args) {
        try {
            login("csdn", "123456");
        }catch (NameException | PasswordException e) {
            e.printStackTrace();
        }
        try {
            login("未见花闻", "123456");
        }catch (NameException | PasswordException e) {
            e.printStackTrace();
        }
        System.out.println("============");
        try {
            login("未见花闻", "5201314");
        }catch (NameException | PasswordException e) {
            e.printStackTrace();
        }
    }
}
