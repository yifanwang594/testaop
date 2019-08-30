package com.van.testaop;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * @Author: Van
 * @Date: 2019/8/30
 * @Description:
 * @Param:
 * @return:
 */
public abstract class BlankUtil {

    private BlankUtil() {
    }

    public static boolean isBlank(Object o) {
        if (o == null)
            return true;
        if (o instanceof String)
            if (((String) o).trim().length() == 0)
                return true;
        if (o instanceof Collection<?>)
            if (((Collection<?>) o).size() == 0)
                return true;
        if (o instanceof Map<?, ?>)
            if (((Map<?, ?>) o).isEmpty())
                return true;
        if (o.getClass().isArray())
            if (Array.getLength(o) == 0)
                return true;
        return false;
    }

    public static boolean isNotBlank(Object o) {
        return !isBlank(o);
    }

    public static boolean isBlankAll(Object... o) {
        if (o == null)
            return true;
        for (Object obj : o)
            if (isNotBlank(obj))
                return false;
        return true;
    }

    public static boolean isNotBlankAll(Object... o) {
        if (o == null)
            return false;
        for (Object obj : o)
            if (isBlank(obj))
                return false;
        return true;
    }

    public static boolean httpNull(String str) {
        return str == null || "".equals(str.trim()) || "null".equalsIgnoreCase(str)
                || "undefined".equalsIgnoreCase(str);
    }

    public static boolean httpNotNull(String str) {
        return !httpNull(str);
    }
}