package com.kindhope.web.captcha;


import com.kindhope.config.Constants;
import com.kindhope.web.captcha.impl.CookieCaptchaImpl;
import com.kindhope.web.captcha.impl.FormCaptchaImpl;
import com.kindhope.web.captcha.impl.SessionCaptchaImpl;

/**
 * @author Yosin_Hasan
 */
public class CaptchaProvider {
    private String method;
    private String name;
    private Long time;

    public CaptchaProvider(String method, String name, Long time) {
        this.method = method;
        this.name = name;
        this.time = time;
    }

    public GenerateCaptcha getCaptchaInstance() {
        GenerateCaptcha instance = null;
        switch (method) {
            case Constants.SESSION:
                instance = new SessionCaptchaImpl(name, time);
                break;
            case Constants.COOKIE:
                instance = new CookieCaptchaImpl(name, time);
                break;
            case Constants.FORM:
                instance = new FormCaptchaImpl(name, time);
                break;
            default:
                instance = new SessionCaptchaImpl(name, time);
                break;
        }
        return instance;
    }

}
