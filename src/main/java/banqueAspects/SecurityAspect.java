package banqueAspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Scanner;

@Aspect
public class SecurityAspect {
    @Pointcut("execution(* test.ApplicationBanque.start(..))")
    public void pc1(){}

    @Around("pc1()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username:");
        String username = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        if (username.equals("admin")&&password.equals("admin"))
            proceedingJoinPoint.proceed();
        else
            System.out.println("Bad Credetials");
    }
}
