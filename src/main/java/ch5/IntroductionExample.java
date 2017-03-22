package ch5;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

public class IntroductionExample {
    public static void main(String[] args) {
        TargetBean target = new TargetBean();
        target.setName("Chris Schafer");

        IntroductionAdvisor advisor = new IsModifiedAdvisor();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setOptimize(true);

        TargetBean proxy = (TargetBean) pf.getProxy();

        IsModified proxyInterface = (IsModified)proxy;
        System.out.println("Is TargetBean?" + (proxyInterface instanceof TargetBean));
        System.out.println("Is IsModified?" + (proxyInterface instanceof IsModified));
        System.out.println("Has bean modified" + proxyInterface.isModified());
        proxy.setName("Chris Schafer");
        System.out.println("Has bean modified" + proxyInterface.isModified());
        proxy.setName("Chris Schafer");
        System.out.println("Has bean modified" + proxyInterface.isModified());
    }
}
