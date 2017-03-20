package com.kindhope.web.captcha;


import com.kindhope.helper.CaptchaStorage;
import com.kindhope.web.captcha.impl.CookieCaptchaImpl;
import com.kindhope.web.captcha.impl.FormCaptchaImpl;
import com.kindhope.web.captcha.impl.SessionCaptchaImpl;

/**
 * @author Yosin_Hasan
 */
public class CaptchaProvider {
    private CaptchaStorage captchaStorage;
    private String name;
    private Long time;

    public CaptchaProvider(CaptchaStorage captchaStorage, String name, Long time) {
        this.captchaStorage = captchaStorage;
        this.name = name;
        this.time = time;
    }

    public GenerateCaptcha getCaptchaInstance() {
        GenerateCaptcha instance = null;
        switch (captchaStorage) {
            case SESSION:
                instance = new SessionCaptchaImpl(name, time);
                break;
            case COOKIE:
                instance = new CookieCaptchaImpl(name, time);
                break;
            case FORM:
                instance = new FormCaptchaImpl(name, time);
                break;
            default:
                instance = new SessionCaptchaImpl(name, time);
                break;
        }
        return instance;
    }

}
