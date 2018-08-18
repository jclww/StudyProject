package com.lww.springbase.aspectj.tx;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AfterCommitAnnotationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(AfterCommitAnnotationAspect.class);

    private final AfterCommitExecutor afterCommitExecutor;

    @Autowired
    public AfterCommitAnnotationAspect(AfterCommitExecutor afterCommitExecutor) {
        this.afterCommitExecutor = afterCommitExecutor;
    }

    @Around(value = "@annotation(com.lww.springbase.aspectj.tx.AfterCommit)", argNames = "pjp")
    public Object aroundAdvice(final ProceedingJoinPoint pjp) {
        afterCommitExecutor.execute(new PjpAfterCommitRunnable(pjp));
        return null;
    }

    private static final class PjpAfterCommitRunnable implements Runnable {
        private final ProceedingJoinPoint pjp;

        public PjpAfterCommitRunnable(ProceedingJoinPoint pjp) {
            this.pjp = pjp;
        }

        @Override
        public void run() {
            try {
                Object returnObject = pjp.proceed();
                LOGGER.info("returnObject:{}", JSON.toJSONString(returnObject));
            }catch (Throwable e) {
                LOGGER.error("Exception while invoking pjp.proceed()", e);
                throw new RuntimeException(e);
            }
        }

        @Override
        public String toString() {
            String typeName = pjp.getTarget().getClass().getSimpleName();
            String methodName = pjp.getSignature().getName();
            Object[] args = pjp.getArgs();
            return "PjpAfterCommitRunnable[type=" + typeName + ", method=" + methodName + ", args=" + JSON.toJSONString(args) + "]";
        }
    }

}
