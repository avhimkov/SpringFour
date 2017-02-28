package ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

public class DestructiveBeanWithinterface {
    private File file;
    private String filePath;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean");
        if (filePath == null) {
            throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBeanWithinterface.class);
        }
        this.file = new File(filePath);
        this.file.createNewFile();

        System.out.println("File exist" + file.exists());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy Bean");

        if (!file.delete()) {
            System.err.println("ERROR: failed to delete file.");
        }
        System.out.println("File exist" + file.exists());
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/app-context-xml.xml");
        ctx.registerShutdownHook();
        ctx.refresh();

        DestructiveBeanWithinterface bean = (DestructiveBeanWithinterface) ctx.getBean("destructiveBean");
    }
}
