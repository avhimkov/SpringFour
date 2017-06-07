package ch7;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class SpringHibernateSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/app-context-annotation.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);

        Contact contact = contactDao.findById(1l);
        System.out.println("");
        System.out.println("Contact with id 1:" + contact);
        System.out.println("");

//        listContacts(contactDao.findAll());
    }
//
//    public static void listContacts (List<Contact> contacts){
//        System.out.println("");
//        System.out.println("List contact without details:");
//
//        for (Contact contact: contacts){
//            System.out.println(contact);
//            if (contact.getContactTelDetails() != null){
//                for (ContactTelDetail contactTelDetail: contact.getContactTelDetails()){
//                    System.out.println(contactTelDetail);
//                }
//            }
//            if (contact.getHobbies()!=null){
//                for (Hobby hobby: contact.getHobbies())
//                System.out.println(hobby);
//            }
//        }
//        System.out.println();
//    }
}
