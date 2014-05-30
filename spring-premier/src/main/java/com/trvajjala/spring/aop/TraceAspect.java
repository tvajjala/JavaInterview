package com.trvajjala.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TraceAspect {

	@Before("execution(* com.trvajjala.spring.aop.CustomerService.*(..))")
	public void traceBefore(JoinPoint joinPoint) {
		System.out.println("=================================================");
		System.out.println("[@Before Aspect ]"
				+ joinPoint.getSignature().getName()
				+ " method executom started   ");
		
		for(Object o:joinPoint.getArgs()){
			System.out.println(o);
		}

	}

	@After("execution(* com.trvajjala.spring.aop.CustomerService.*(..))")
	public void traceAfter(JoinPoint joinPoint) {

		System.out.println("[@After Aspect ]"
				+ joinPoint.getSignature().getName()
				+ " method executom completed   ");

		System.out.println("=================================================");
	}

	@AfterReturning(pointcut = "execution(* com.trvajjala.spring.aop.CustomerService.getCustomer(..))", returning = "result")
	public void traceAfterReturn(JoinPoint joinPoint, Object result) {
		System.out.println("[@AfterReturning Aspect ]"
				+ joinPoint.getSignature().getName() + "  returned  " + result);
	}

	@Around("execution(* com.trvajjala.spring.aop.CustomerService.*(..))")
	public void traceAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("\n-----------------------------------------------");
		System.out.println("[@Around Aspect ]"
				+ joinPoint.getSignature().getName() + " Starting ");

		joinPoint.proceed(); // continue on the intercepted method

		System.out.println("[@Around Aspect ]"
				+ joinPoint.getSignature().getName() + " Ending ");

		System.out.println("---------------------------------------------\n");

	}

}
