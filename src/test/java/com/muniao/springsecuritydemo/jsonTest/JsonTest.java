package com.muniao.springsecuritydemo.jsonTest;

import com.muniao.springsecuritydemo.annotation.ClassName;
import com.muniao.springsecuritydemo.annotation.FieldName;
import com.muniao.springsecuritydemo.util.BeanMapUtil;
import com.muniao.springsecuritydemo.util.FastJsonUtil;
import com.muniao.springsecuritydemo.util.GsonUtil;
import com.muniao.springsecuritydemo.util.JacksonUtil;
import com.muniao.springsecuritydemo.vo.FullName;
import com.muniao.springsecuritydemo.vo.Person;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JsonTest
{
    public static void test1(Person p)
    {
        Class clazz = p.getClass();

        ClassName className = (ClassName) clazz.getAnnotation(ClassName.class);
        if(className!=null)
            System.out.println("className="+className.value());

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields)
        {
            System.out.println(field.getName());

            FieldName fieldName = field.getAnnotation(FieldName.class);
            if (fieldName != null)
            {
                System.out.println("fieldName=" + fieldName.value());
            }


        }
    }

    public static void main(String[] args)
    {
        Person p = new Person();
        p.setAge(20);
        p.setBirthday(LocalDate.now());
        p.setName("李小鹏");
        p.setClothes(new HashMap<String, String>()
        {
            {
                put("aa", "11");
                put("bb", "22");
            }
        });

        p.setFullName(new FullName("李", "小", "鹏"));
        p.setHobbies(Arrays.asList("篮球", "羽毛球"));

        System.out.println(p);

        test1(p);


                System.out.println("=============Bean Map=============");

                Map<String, Object> map = BeanMapUtil.bean2Map(p);
                System.out.println(map);

                Person mapPerson = BeanMapUtil.map2Bean(map, Person.class);
                System.out.println(mapPerson);

                System.out.println("============fast Json==============");

                String jsonStr1 = FastJsonUtil.bean2Json(p);
                System.out.println(jsonStr1);
                Person p1 = FastJsonUtil.json2Bean(jsonStr1, Person.class);
                System.out.println(p1);

                System.out.println("============Gson==============");

                String jsonStr2 = GsonUtil.bean2Json(p);
                System.out.println(jsonStr2);
                Person p2 = GsonUtil.json2Bean(jsonStr2, Person.class);
                System.out.println(p2);

                System.out.println("===========jackson===============");
                String jsonStr3 = JacksonUtil.bean2Json(p);
                System.out.println(jsonStr3);
//                Person p3 = JacksonUtil.json2Bean(jsonStr3, Person.class);
//                System.out.println(p3);

    }
}
