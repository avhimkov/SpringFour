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

        ContactAuditService contactService = ctx.getBean("contactAuditService", ContactAuditService.class);
        List<ContactAudit> contacts = contactService.findAll();
        listContacts(contacts);

        System.out.println ("Add new contact");
        ContactAudit contact = new ContactAudit();
        contact.setFirstName("Мichael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());
        contactService.save(contact);
        contacts = contactService.findAll();
        listContacts(contacts);
        contact = contactService.findById(1l);
        System.out.println("");
        System.out.println("Contact with id 1:" + contact);
        System.out.println("");
        System.out.println("Update contact");
        contact.setFirstName("Tom");
        contactService.save(contact);
        contacts = contactService.findAll();
        listContacts(contacts);
    }

    public static void listContacts (List<ContactAudit> contacts){
        System.out.println("");
        System.out.println("Listing contacts without details:");

        for (ContactAudit contact: contacts){
            System.out.println(contact);
            System.out.println();
        }
    }
}
