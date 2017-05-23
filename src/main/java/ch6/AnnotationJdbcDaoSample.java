package ch6;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.ArrayList;
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
        contact.setFirstName("Michael");
        contact.setLastName("Johnson");
        contact.setLastName(new Date(new GregorianCalendar(1964, 10 ,1).getTime().getTime()));
        List<ContactTelDetail> contactTelDetails = new ArrayList<ContactTelDetail>();
        ContactTelDetail contactTelDetail = new ContactTelDetail();
        contactTelDetail.setTelType("Home");
        contactTelDetail.setTelNumber("11111111");
        contactTelDetails.add(contactTelDetail);
        contactTelDetail = new ContactTelDetail();
        contactTelDetail.setTelType("Mobile");
        contactTelDetail.setTelNumber("2222222");
        contactTelDetails.add(contactTelDetail);
        contact.setContactTelDetails(contactTelDetails);
        contactDao.insertWithDetail(contact);

        listContacts(contactDao.findAllWithDetail());
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
