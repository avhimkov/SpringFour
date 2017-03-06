package ch4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource(value = "classpath:META-INF/app-context-xml.xml")
@PropertySource(value = "message.properties")
@ComponentScan(basePackages = {})
@EnableTransactionManagement
public class AppConfig {
    @Autowired
    Environment env;

    @Bean
    @Lazy(value = true)
    public MessageProvider messageProvider () {
        return new ConfigurableMessageProvider(env.getProperty("message"));
    }

    @Bean(name = "messageRenderer")
    @Scope(value = "prototype")
    @DependsOn(value = "messageProvider")
    public MessageRenderer messageRenderer(){
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());
        return renderer;
    }


}
