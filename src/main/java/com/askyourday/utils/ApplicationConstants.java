package com.askyourday.utils;

public class ApplicationConstants {
    public static final String UTF8 = "UTF8";

    public static final String INPUT_DATE_FORMAT_PATTERN = "dd.MM.yyyy";
    public static final String JSP_INPUT_DATE_FORMAT_PATTERN = "dd.mm.yy";

    // URL Shortener vars
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static final int BASE = 62;

    // Crypting settings
    public static final String myEncryptionKey = "ThisIsSpartaThisIsSparta";
    public static final String myEncryptionScheme = "DESede";

    public static final String FACEBOOK_APP_ID = "245876892501434";
    public static final String FACEBOOK_REDIRECT_URL = "https://askyourday.com/login/facebook?authCode=";
    public static final String FACEBOOK_SECRET_KEY = "717163a63891cc1834e9021e8fbbaa2c";
    public static final String FACEBOOK_EXCHANGE_KEY = "";
    public static final String FACEBOOK_KEY_WORD = "facebook-auth-key";

    // Exceptions Errors codes
    public static final Integer INTERNAL_EXCEPTION_CODE = 0;
    public static final Integer FACEBOOK_LOGIN_EXCEPTION_MESSAGE = 3;

}
