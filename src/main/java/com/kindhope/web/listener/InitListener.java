package com.kindhope.web.listener;

import com.kindhope.config.Constants;
import com.kindhope.web.captcha.CaptchaProvider;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class InitListener implements ServletContextListener {
    private static final Logger LOG = Logger.getLogger(InitListener.class);

    public final void contextInitialized(final ServletContextEvent sce) {
        LOG.info("Servlet context initialization starts");
        String method = sce.getServletContext().getInitParameter("captchaMethod");
        Long captchaLifeTime = Long.parseLong(sce.getServletContext().getInitParameter("captchaLifeTime"));
        CaptchaProvider provider = new CaptchaProvider(method, Constants.CAPTCHA_NAME, captchaLifeTime);
        sce.getServletContext().setAttribute("captchaInstance", provider.getCaptchaInstance());
        LOG.info("Servlet context initialization finished");
    }

    public void contextDestroyed(final ServletContextEvent sce) {
    }

}
