package ch8;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class SpringJPASample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/app-context-annotation.xml");
        ctx.refresh();

        ContactSummaryUntypeImpl contactSummaryUntype = ctx.getBean("contactSummaryUntype", ContactSummaryUntypeImpl.class);
        contactSummaryUntype.displayAllContactSummary();

//        ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);
//        List<Contact> contacts = contactService.findAllWithDetail();
//        listContactsWithDetail(contacts);
    }

//    public static void listContactsWithDetail (List<Contact> contacts){
//        System.out.println("");
//        System.out.println("List contacts with details:");
//
//        for (Contact contact: contacts){
//            System.out.println(contact);
//            if (contact.getContactTelDetails()!=null){
//                for (ContactTelDetail contactTelDetail: contact.getContactTelDetails()){
//                    System.out.println(contactTelDetail);
//                }
//            }
//            if (contact.getHobbies()!=null){
//                for (Hobby hobby:contact.getHobbies()){
//                    System.out.println(hobby);
//                }
//            }
//            System.out.println();
//        }
//    }
}
