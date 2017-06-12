package ch8;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class SpringJPASample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/app-context-annotation.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);

        listContacts(contactService.findAll());
    }

    public static void listContacts (List<Contact> contacts){
        System.out.println("");
        System.out.println("List contacts with details:");

        for (Contact contact: contacts){
            System.out.println(contact);
            System.out.println();
        }
    }
}
