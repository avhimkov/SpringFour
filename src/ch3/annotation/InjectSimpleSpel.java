package ch3.annotation;

import ch3.xml.InjectSimple;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimpleSpel")
public class InjectSimpleSpel {
    @Value("#{injectSimleConfig.name}")
    private String name;
    @Value("#{injectSimleConfig.age+1}")
    private int age;
    @Value("#{injectSimleConfig.height}")
    private float height;
    @Value("#{injectSimleConfig.programmer}")
    private boolean programmer;
    @Value("#{injectSimleConfig.ageInSeconds}")
    private Long ageInSeconds;


    public Long getAgeInSeconds() {
        return ageInSeconds;
    }

    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String toString(){
        return  "Name :" + name + "\n" + "Age:" + age + "\n" + "Age in Second: " + ageInSeconds + "\n" + "Height: " + height + "\n" + "Is Programmer?" + programmer;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();
        InjectSimple simple = (InjectSimple) ctx.getBean("injectSimpleSpel");
        System.out.println(simple);
    }
}
