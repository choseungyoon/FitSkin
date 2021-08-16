package com.fitksin.server.common.utils;

import java.lang.reflect.Method;
import java.util.Date;

public class EntityUtils {

    public static <T> void initializeInviteAndLastLoginDate(T domain){
        Class<? extends Object> clazz = domain.getClass();
        Class[] paramType = new Class[]{Date.class};
        Object[] paramValue = new Object[] {new Date()};

        try{
            Method setInviteMethod = clazz.getMethod("setInviteDate",paramType);
            setInviteMethod.invoke(domain,paramValue);

            Method setLastLoginMethod = clazz.getMethod("setLastLoginDate",paramType);
            setLastLoginMethod.invoke(domain,paramValue);

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
     }

}
