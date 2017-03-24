package ch5;

public class MyBean {
    private MyDependency dep;

    public void execute(){
        dep.foo(100);
        dep.bar(101);
    }

    public void setDep(MyDependency dep) {
        this.dep = dep;
    }
}
