package com.kortov.aop.aspect;

import com.kortov.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.kortov.aop.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String method = proceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @Around on method: " + method);
        long begin = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            myLogger.warning(throwable.getMessage());
            result = "Major accident! But no worries," +
                    "your private AOP helicopter is on the way!";
        }
        long end  = System.currentTimeMillis();
        long duration = end - begin;
        myLogger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");
        return result;
    }


    @After("execution(* com.kortov.aop.dao.AccountDAO.findAccounts(..))")
    public void afterFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @After on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.kortov.aop.dao.AccountDAO.findAccounts(..))",
            throwing = "exc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Exception exc) {
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @AfterThrowing on method: " + method);
        myLogger.info("\n=====>>> The excepition is: " + exc);
    }

    @AfterReturning(
            pointcut = "execution(* com.kortov.aop.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        myLogger.info("\n=====>>> result is: " + result);
        convertAccountNamesToUpperCase(result);
        myLogger.info("\n=====>>> result is: " + result);
    }

    @Before("com.kortov.aop.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        myLogger.info("\n=====>>> Executing @Before advice on method()");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        myLogger.info("Method: " + methodSignature);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            myLogger.info(arg.toString());
            if (arg instanceof Account) {
                Account account = (Account) arg;
                myLogger.info("Account name: " + account.getName());
                myLogger.info("Account level: " + account.getLevel());
            }
        }
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account tempAccount : result) {
            String theUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }
    }
}
