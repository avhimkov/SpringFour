package ch5;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.aop.ClassFilter;
import java.lang.reflect.Method;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> cls) {
        return ("foo".equals(method.getName()));
    }

    @Override
    public ClassFilter getClassFilter(){
        return new ClassFilter(){
            public boolean matches(Class<?> cls){
                return (cls == BeanOne.class);
            }
        };
    }
}
