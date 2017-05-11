package ch6;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class JdbcContactDaoSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/app-context-xml.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        List<Contact> contactsWithDetail = contactDao.findAllWithDetail();
        for (Contact contact : contactsWithDetail){
            System.out.println(contact);
            if (contact.getContactTelDetails()!=null){
                for (ContactTelDetail contactTelDetail:contact.getContactTelDetails()){
                    System.out.println("---" + contactTelDetail);
                }
            }
            System.out.println();
        }
    }
}
