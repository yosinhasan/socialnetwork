package com.kindhope.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>.
 */
@Aspect
@Component
public class DAOAspect {
    private static final Logger LOG = Logger.getLogger(DAOAspect.class);

    @Around("com.kindhope.aspect.SystemArchitecture.dataAccessOperation()")
    public Object doOperation(ProceedingJoinPoint pjp) throws Throwable {
        LOG.debug("DAO OPERATION START");
        LOG.trace("CLASS: " + pjp.getThis());
        LOG.trace("METHOD NAME: " + pjp.getSignature().getName());
        Object object = pjp.proceed();
        LOG.trace("OUTPUT DATA: " + object);
        LOG.debug("DAO OPERATION END");
        return object;
    }

}
