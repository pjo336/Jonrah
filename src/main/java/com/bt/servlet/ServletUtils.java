package com.bt.servlet;

/**
 * User: Peter Johnston
 * Date: 12/15/13
 */
public class ServletUtils {

    public static <T> T coalesce(T...ts) {
        for(T t: ts)
            if(t != null)
                return t;
        return null;
    }
}
