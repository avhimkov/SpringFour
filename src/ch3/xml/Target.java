package ch3.xml;

import ch3.Bar;
import ch3.Foo;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Target {
    private Foo foo;
    private Foo foo2;
    private Bar bar;

    public Target() {
    }

    public Target(Foo foo) {
        System.out.println("Target(Foo) called");
    }


    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    public void setFoo2(Foo foo2) {
        this.foo2 = foo2;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:ch3/xml/app-context-xml.xml");
        ctx.refresh();

        Target t = null;
        System.out.println("Using byName:\n");
        t = (Target) ctx.getBean("targetByName");

        System.out.println("\nUsing byType:\n");
        t = (Target) ctx.getBean("targetByType");

        System.out.println("\nUsing constructor:\n");
        t = (Target) ctx.getBean("targetConstructor");
    }
}
