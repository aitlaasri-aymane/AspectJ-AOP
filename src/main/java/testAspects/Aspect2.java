package testAspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Aspect2 {
    @Pointcut("execution(* test.Application.main(..))")
    public void pc1(){}
    /*
    @Before("pc1()")
    public void beforeMain(){
        System.out.println("Before main Aspect2");
    }
    @After("pc1()")
    public void afterMain(){
        System.out.println("After main Aspect2");
    }
     */
    @Around("pc1()")
    public void aroundMain(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around Before main Aspect2");
        proceedingJoinPoint.proceed();
        System.out.println("Around After main Aspect2");
    }
}
