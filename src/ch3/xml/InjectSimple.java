package ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimple {
    private String name;
    private int age;
    private float height;
    private boolean programmer;
    private long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-xml.xml");
        ctx.refresh();

        InjectSimple simple = (InjectSimple) ctx.getBean("injectionSimple");
        System.out.println(simple);
    }

    public void setAgeInSeconds(long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String toString(){
        return  "Name :" + name + "\n" + "Age:" + age + "\n" + "Age in Second: " + ageInSeconds + "\n" + "Height: " + height + "\n" + "Is Programmer?" + programmer;
    }
}
