package ch5;

public class SecurityManager {
    private static ThreadLocal<Userinfo> threadLocal = new ThreadLocal<Userinfo>();

    public void login(String userName, String passwor){
        threadLocal.set(new Userinfo(userName, passwor));
    }

    public void logout(){
        threadLocal.set(null);
    }

    public Userinfo getLoggetOnUser(){
        return threadLocal.get();
    }
}
