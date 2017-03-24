package ch5;

import org.aspectj.lang.JoinPoint;

public class MyAdvice {
    public void simleBeforAdvice(JoinPoint joinPoint){
        System.out.println("Executing" + joinPoint.getSignature().getDeclaringTypeName() + " " + joinPoint.getSignature().getName());
    }
}
