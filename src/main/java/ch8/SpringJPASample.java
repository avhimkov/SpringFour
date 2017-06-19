package ch8;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class SpringJPASample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/app-context-annotation.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);
//        List<Contact> contacts = contactService.findByCriteriaQuery("John","Smith");
//        listContactsWithDetail(contacts);
//        contact.setLastName("Jackson");
//        contact.setBirthDate(new Date());

//        ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "1111111111");
//        contact.addContactTelDetail(contactTelDetail);
//        contactTelDetail = new ContactTelDetail("Mobile", "2222222222");
//        contact.addContactTelDetail(contactTelDetail);
//        contactService.save(contact);
//        listContactsWithDetail(contactService.findAllWithDetail());
    }

    public static void listContactsWithDetail (List<Contact> contacts){
        System.out.println("");
        System.out.println("List contacts with details:");

        for (Contact contact: contacts){
            System.out.println(contact);
            if (contact.getContactTelDetails()!=null){
                for (ContactTelDetail contactTelDetail: contact.getContactTelDetails()){
                    System.out.println(contactTelDetail);
                }
            }
            if (contact.getHobbies()!=null){
                for (Hobby hobby:contact.getHobbies()){
                    System.out.println(hobby);
                }
            }
            System.out.println();
        }
    }
}
