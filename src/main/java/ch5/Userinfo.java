package ch5;

public class Userinfo {
    private String userName, password;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Userinfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
