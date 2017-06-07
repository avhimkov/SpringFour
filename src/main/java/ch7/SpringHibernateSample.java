package ch7;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class SpringHibernateSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/app-context-annotation.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);

        Contact contact = new Contact();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());

        ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "1111111111");
        contact.addContactTelDetail(contactTelDetail);

        contactTelDetail = new ContactTelDetail("Mobile", "2222222222");

        contact.addContactTelDetail(contactTelDetail);
        contactDao.save(contact);

        listContactsWithDetail(contactDao.findAll());
    }

    public static void listContactsWithDetail (List<Contact> contacts){
        System.out.println("");
        System.out.println("List contacts with details:");

        for (Contact contact: contacts){
            System.out.println(contact);
            if (contact.getContactTelDetails() != null){
                for (ContactTelDetail contactTelDetail: contact.getContactTelDetails()){
                    System.out.println(contactTelDetail);
                }
            }
            if (contact.getHobbies()!=null){
                for (Hobby hobby: contact.getHobbies())
                System.out.println(hobby);
            }
        }
        System.out.println();
    }
}
