package com.muniao.springsecuritydemo.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
@Order(98)
public class MyApplicationRunner1 implements ApplicationRunner
{
    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        //可以用来获取命令行中的无key参数
        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("MyApplicationRunner1>>>"+nonOptionArgs);

      //可以用来获取所有key/value形式的参数的key
        Set<String> optionNameSet = args.getOptionNames();
        optionNameSet.forEach(key-> System.out.println(key+":"+args.getOptionValues(key)));

        //则表示获取命令行中的所有参数
        String[] sourceArgs = args.getSourceArgs();
        System.out.println("MyApplicationRunner1>>>"+ Arrays.toString(sourceArgs));

    }
}
