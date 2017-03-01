package ch4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ShutdownHookBean implements ApplicationContextAware {

    private ApplicationContextAware ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ctx instanceof ApplicationContextAware) {
            ((GenericXmlApplicationContext) ctx).registerShutdownHook();
        }
    }
}
