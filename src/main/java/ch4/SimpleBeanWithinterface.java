package ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanWithinterface implements InitializingBean{
    private static final String DEFAULT_NAME = "Luke Skywalker";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Init bean");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Уои must set the age property of any beans of type" + SimpleBean.class);
        }
    }

    public String toString() {
        return "Name: " + name + "\nAge:" + age;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/app-context-xml.xml");
        ctx.refresh();

        SimpleBeanWithinterface simpleBean1 = getBean("simpleBean1", ctx);
        SimpleBeanWithinterface simpleBean2 = getBean("simpleBean2", ctx);
        SimpleBeanWithinterface simpleBean3 = getBean("simpleBean3", ctx);
    }

    private static SimpleBeanWithinterface getBean(String beanName, ApplicationContext ctx) {
        try {
            SimpleBeanWithinterface bean = (SimpleBeanWithinterface) ctx.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration:" + ex.getMessage());
            return null;
        }
    }


}
