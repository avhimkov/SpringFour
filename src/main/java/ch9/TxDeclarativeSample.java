package ch9;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class TxDeclarativeSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/tx-programmatic-app-context.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("contactService", ContactService.class);

        List<Contact> contacts = contactService.findAll();
        for (Contact contactTemp: contacts){
            System.out.println(contactTemp);
        }
        Contact contact = contactService.findById(1L);
        contact.setFirstName("Peter");
        contactService.save(contact);
        System.out.println("Contact saved successfully");
        System.out.println("Contact count: " + contactService.countAll());

    }
}
