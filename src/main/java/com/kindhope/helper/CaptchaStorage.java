package com.kindhope.helper;

/**
 * CaptchaStorage.
 *
 * @author Yosin_Hasan
 * @version 0.0.1
 */
public enum CaptchaStorage {
    SESSION("session"),
    COOKIE("cookie"),
    FORM("form"),
    UNDEFINED("undefined");

    private String value;

    CaptchaStorage(String value) {
        this.value = value;
    }

    public static final CaptchaStorage getValueOf(String value) {
        CaptchaStorage returnValue = UNDEFINED;
        for (CaptchaStorage captchaStorage : CaptchaStorage.values()) {
            if (captchaStorage.value.equals(value)) {
                returnValue = captchaStorage;
                break;
            }
        }
        return returnValue;
    }
}
