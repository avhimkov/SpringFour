package ch7;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class SpringHibernateSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/app-context-annotation.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);

        Contact contact = contactDao.findById(1l);
        contactDao.delete(contact);
//        contact.setFirstName("Kim Fung");
//        Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
//
//        ContactTelDetail toDeleteContactTel = null;
//
//        for (ContactTelDetail contactTel: contactTels){
//            if (contactTel.getTelType().equals("Home")){
//                toDeleteContactTel = contactTel;
//            }
//        }
//
//        contact.removeContactTelDetail(toDeleteContactTel);
//        contactDao.save(contact);

        listContactsWithDetail(contactDao.findAllWithDetail());
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
