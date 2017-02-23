package ch3;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/Spring/parent.xml");
        ctx.refresh();

        ReplacementTarget replacementTarget = (ReplacementTarget) ctx.getBean("replacementTarget");
        ReplacementTarget standardTarget = (ReplacementTarget) ctx.getBean("standardTarget");

        displayInfo(replacementTarget);
        displayInfo(replacementTarget);

    }

    public static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Hello world"));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");

        for (int x = 0; x <1000000 ; x++) {
            String out = target.formatMessage("foo");
        }
        stopWatch.stop();

        System.out.println("lOOOOOO invocations took: " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
