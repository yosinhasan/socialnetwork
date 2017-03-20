package com.kindhope.web.listener;

import com.kindhope.helper.CaptchaStorage;
import com.kindhope.helper.Constants;
import com.kindhope.web.captcha.CaptchaProvider;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class ContextInitListener implements ServletContextListener {
    private static final Logger LOG = Logger.getLogger(ContextInitListener.class);

    public final void contextInitialized(final ServletContextEvent sce) {
        LOG.info("Servlet context initialization starts");
        String captchaName = sce.getServletContext().getInitParameter("captchaMethod");
        Long captchaLifeTime = Long.parseLong(sce.getServletContext().getInitParameter("captchaLifeTime"));
        CaptchaProvider provider = new CaptchaProvider(CaptchaStorage.getValueOf(captchaName), Constants.CAPTCHA_NAME, captchaLifeTime);
        sce.getServletContext().setAttribute("captchaInstance", provider.getCaptchaInstance());
        LOG.info("Servlet context initialization finished");
    }

    public void contextDestroyed(final ServletContextEvent sce) {
    }

}
