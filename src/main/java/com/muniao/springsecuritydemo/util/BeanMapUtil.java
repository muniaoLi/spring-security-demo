package com.muniao.springsecuritydemo.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class BeanMapUtil
{
    /**
     * 对象转换为Map
     *
     * @param source 对象
     * @param <T>    对象类型
     * @return 对象对应的Map
     */
    public static <T> Map<String, Object> bean2Map(T source)
    {
        Map<String, Object> resultMap = new HashMap<>();

        try
        {
            Class<?> sourceClass = source.getClass();
            Field[] sourceFields = sourceClass.getDeclaredFields();
            for (Field field : sourceFields)
            {
                field.setAccessible(true);
                resultMap.put(field.getName(), field.get(source));
            }
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }

        return resultMap;
    }

    public static <T> T map2Bean(Map<String, Object> map, Class<T> beanClass)
    {
        try
        {
            T resultObj = beanClass.newInstance();
            Field[] fields = beanClass.getDeclaredFields();
            for (Field field : fields)
            {
                field.setAccessible(true);
                field.set(resultObj, map.get(field.getName()));
            }

            return resultObj;
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
