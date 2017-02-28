package ch4;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

public class DestructiveBeanWithinterface implements InitializingBean, DisposableBean {
    private File file;
    private String filePath;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean");
        if (filePath == null){
            throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBeanWithinterface.class);
        }
        this.file = new File(filePath);
        this.file.createNewFile();

        System.out.println("File exist"+file.exists());
    }

    @Override
    public void destroy(){
        System.out.println("Destroy Bean");

        if (!file.delete()){
            System.err.println("ERROR: failed to delete file.");
        }
        System.out.println("File exist"+file.exists());
    }

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/app-context-xml.xml");
        ctx.refresh();

        DestructiveBeanWithinterface bean = (DestructiveBeanWithinterface) ctx.getBean("destructiveBean");
        System.out.println("Calling destroy ()");
        ctx.destroy();
        System.out.println("Called destroy ()");
    }
}
