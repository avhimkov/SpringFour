package ch5;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.aop.ClassFilter;
import java.lang.reflect.Method;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut{

    @Override
    public boolean matches(Method method, Class<?> cls) {
        System.out.println("Static check for " + method.getName());
        return ("foo".equals(method.getName()));
    }

    @Override
    public boolean matches(Method method, Class<?> cls, Object... args) {
        System.out.println("Dynamic check for " + method.getName());
        int x = (Integer) args[0];
        return (x!=100);
    }

    @Override
    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> cls) {
                return (cls==SampleBean.class);
            }
        };
    }
}
