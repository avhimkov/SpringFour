package ch6;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JdЬcContactDaoSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/app-context-xml.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        System.out.print("First name for contact id 1 is: " + contactDao.findFirstNameById((long) 11));
    }
}
