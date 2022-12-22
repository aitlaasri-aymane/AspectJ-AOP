package testAspects;

public aspect Aspect1 {
    pointcut pc1():execution(* test.Application.main(..));
    /*
    before() : pc1(){
        System.out.println("before");
    }
    after() : pc1(){
        System.out.println("after");
    }
     */
    // Can only use one of these around or after and before
    void around() : pc1(){
        System.out.println("Around before");
        proceed();
        System.out.println("Around after");
    }
}
