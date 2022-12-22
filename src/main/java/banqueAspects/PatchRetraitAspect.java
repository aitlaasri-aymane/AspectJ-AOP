package banqueAspects;

import metier.Compte;
import metier.MetierBanqueImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PatchRetraitAspect {
    @Pointcut("execution(* metier.MetierBanqueImpl.retirer(..))")
    public void pc1(){}

    @Around("pc1() && args(montant,code)") // Make sure they r in correct order
    public Object around(double montant, long code, ProceedingJoinPoint proceedingJoinPoint, JoinPoint joinPoint) throws Throwable {
        MetierBanqueImpl metierBanque = (MetierBanqueImpl) joinPoint.getTarget();
        Compte compte = metierBanque.consulterCompte(code);
        if (compte.getSolde() < montant) throw new RuntimeException("Solde Insuffisant");
        return proceedingJoinPoint.proceed();
    }
}
