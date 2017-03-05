package ch4;

import org.springframework.context.support.GenericXmlApplicationContext;
import java.util.Locale;

public class MessageSourceDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/app-context-xml.xml");
        ctx.refresh();

        Locale english = Locale.ENGLISH;
        Locale czech = new Locale("ch" , "CZ");

        System.out.println(ctx.getMessage("msg", null, english));
        System.out.println(ctx.getMessage("msg", null, czech));
        System.out.println(ctx.getMessage("nameMsg", new Object[]{"Chris", "Shaefer"}, english));
    }
}
