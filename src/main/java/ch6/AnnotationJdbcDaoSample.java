package ch6;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class AnnotationJdbcDaoSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/app-context-annotation.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        Contact contact = new Contact();
        contact.setFirstName("Rod");
        contact.setLastName("Johnson");
        contact.setLastName(new Date(new GregorianCalendar(2001, 10 ,1).getTime().getTime()));
        contactDao.insert(contact);

        listContacts(contactDao.findAll());
    }

    private static void listContacts(List<Contact> contacts){
        for (Contact contact: contacts){
            System.out.println(contact);
            if (contact.getContactTelDetails()!= null){
                for (ContactTelDetail contactTelDetail:contact.getContactTelDetails()){
                    System.out.println("---" + contactTelDetail);
                }
            }
            System.out.println();
        }
    }
}
