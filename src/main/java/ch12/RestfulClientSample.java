package ch12;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

public class RestfulClientSample {
    private static final String URL_GET_ALL_CONTACTS =
            "http://localhost:8080/ch12/restful/contact/listdata";
    private static final String URL_GET_CONTACT_BY_ID =
            "http://localhost:8080/ch12/restful/contact/{id}";
    private static final String URL_CREATE_CONTACT =
            "http://localhost:8080/ch12/restful/contact/";
    private static final String URL_UPDATE_CONTACT =
            "http://localhost:8080/ch12/restful/contact/{id}";
    private static final String URL_DELETE_CONTACT =
            "http://localhost:8080/ch12/restful/contact/{id}";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/restful-client-app-context.xml");
        ctx.refresh();
        Contact contact;
        RestTemplate restTemplate = ctx.getBean("restTemplate", RestTemplate.class);
        System.out.println("Testing retrieve all contacts:");
        Contacts contacts = restTemplate.getForObject(URL_GET_ALL_CONTACTS, Contacts.class);
        listContacts(contacts);

        System.out.println("Testing retrieve а contact bу id :");
        contact = restTemplate.getForObject(URL_GET_CONTACT_BY_ID, Contact.class, 1);
        System.out.println(contact);
        System.out.println("");
    }

    private static void listContacts (Contacts contacts){
        for (Contact contact: contacts.getContacts()){
            System.out.println(contact);
        }
        System.out.println("");
    }
}
