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

        ContactService contactService = ctx.getBean("springJpaContactService", ContactService.class);
        listContacts("Find all:", contactService.findAll());
        listContacts("Find by first name:", contactService.findByFirstName("Chris"));
        listContacts("Find by first name and last name:", contactService.findByFirstNameAndLastName("Chris", "Schaefer"));
    }

    public static void listContacts (String message, List<Contact> contacts){
        System.out.println("");
        System.out.println(message);

        for (Contact contact: contacts){
            System.out.println(contact);
            System.out.println();
        }
    }
}
