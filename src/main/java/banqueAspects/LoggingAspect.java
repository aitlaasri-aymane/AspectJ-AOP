package banqueAspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    public LoggingAspect() throws IOException {
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false); // Disable displaying logs in terminal
    }

    long t1,t2;
    @Pointcut("execution(* metier.MetierBanqueImpl.*(..))")
    public void pc1(){}
    /*
    @Before("pc1()")
    public void beforeMain(JoinPoint joinPoint){
        t1=System.currentTimeMillis();
        logger.info("----------");
        logger.info("Avant l'execution de la methode"+joinPoint.getSignature());
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(arg -> System.out.println(arg));
    }
    @After("pc1()")
    public void afterMain(JoinPoint joinPoint){
        logger.info("Apres l'execution de la methode"+joinPoint.getSignature());
        t2=System.currentTimeMillis();
        logger.info("duree d'execution de la methode:"+(t2-t1)+" ms");
        logger.info("----------");
    }
     */

    @Around("pc1()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, JoinPoint joinPoint) throws Throwable {
        t1=System.currentTimeMillis();
        logger.info("----------");
        logger.info("Avant l'execution de la methode"+joinPoint.getSignature());
        Object result = proceedingJoinPoint.proceed();
        logger.info("Apres l'execution de la methode"+joinPoint.getSignature());
        t2=System.currentTimeMillis();
        logger.info("duree d'execution de la methode:"+(t2-t1)+" ms");
        logger.info("----------");
        return result;
    }
}
