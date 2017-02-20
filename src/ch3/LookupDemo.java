package ch3;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        DemoBean abstractBean = (DemoBean) ctx.getBean("abstractLookupBean");
        DemoBean standartBean = (DemoBean) ctx.getBean("abstractLookupBean");

        displayInfo(standartBean);
        displayInfo(abstractBean);
    }

    public static void displayInfo(DemoBean bean){
        MyHelper helper1 = bean.getHelper();
        MyHelper helper2 = bean.getHelper();

        System.out.println("Helper Instances the Same?: " + (helper1==helper2));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");

        for (int x = 0; x<100000; x++){
            MyHelper helper = bean.getHelper();
            helper.doSomethingHelpful();
        }

        stopWatch.stop();
        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
