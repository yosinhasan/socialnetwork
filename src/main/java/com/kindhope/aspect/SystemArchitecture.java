package com.kindhope.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>.
 */
@Aspect
@Component
public class SystemArchitecture {
    /**
     * A join point is in the web layer if the method is defined
     * in a type in the com.kindhope.web package or any sub-package
     * under that.
     */
    @Pointcut("within(com.kindhope.web..*)")
    public void inWebLayer() {
    }

    /**
     * A join point is in the service layer if the method is defined
     * in a type in the com.kindhope.service package or any sub-package
     * under that.
     */
    @Pointcut("within(com.kindhope.service..*)")
    public void inServiceLayer() {
    }

    /**
     * A join point is in the data access layer if the method is defined
     * in a type in the com.kindhope.dao package or any sub-package
     * under that.
     */
    @Pointcut("within(com.kindhope.dao..*)")
    public void inDataAccessLayer() {
    }

    /**
     * A business service is the execution of any method defined on a service
     * interface. This definition assumes that interfaces are placed in the
     * "service" package, and that implementation types are in sub-packages.
     * <p>
     * If you group service interfaces by functional area (for example,
     * in packages com.xyz.someapp.abc.service and com.xyz.someapp.def.service) then
     * the pointcut expression "execution(* com.xyz.someapp..service.*.*(..))"
     * could be used instead.
     * <p>
     * Alternatively, you can write the expression using the 'bean'
     * PCD, like so "bean(*Service)". (This assumes that you have
     * named your Spring service beans in a consistent fashion.)
     */
    @Pointcut("execution(* com.kindhope.service.*.*(..))")
    public void businessService() {
    }

    /**
     * A data access operation is the execution of any method defined on a
     * dao interface. This definition assumes that interfaces are placed in the
     * "dao" package, and that implementation types are in sub-packages.
     */
    @Pointcut("execution(* com.kindhope.dao.*.*(..))")
    public void dataAccessOperation() {
    }
}
