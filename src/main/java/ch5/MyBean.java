package ch5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {
    private MyDependency dep;

    public void execute(){
        dep.foo(100);
        dep.foo(101);
        dep.bar();
    }

    @Autowired
    public void setDep(MyDependency myDependency) {
        this.myDependency = myDependency;
    }
}
