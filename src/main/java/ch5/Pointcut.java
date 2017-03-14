package ch5;

import jdk.nashorn.api.scripting.ClassFilter;
import org.springframework.aop.MethodMatcher;

public interface Pointcut {
    ClassFilter getClassFilter();
    MethodMatcher getMethodMathcher();
}
