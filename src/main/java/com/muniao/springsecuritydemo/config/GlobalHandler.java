package com.muniao.springsecuritydemo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalHandler
{

    /**
     * 全局异常处理
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView customException(Exception e)
    {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", e.getMessage());
        mv.setViewName("myerror");
        return mv;
    }


    @ModelAttribute(name = "md")
    public Map<String, Object> globalDataBind()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("name","lixp");
        map.put("age", 30);
        return map;
    }


}
