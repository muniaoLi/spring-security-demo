package com.muniao.springsecuritydemo.vo;

import com.muniao.springsecuritydemo.annotation.ClassName;
import com.muniao.springsecuritydemo.annotation.FieldName;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@ClassName("personClass")
public class Person
{
    @FieldName("personName")
    private String name;
    private FullName fullName;
    private int age;
    private LocalDate birthday;
    private List<String> hobbies;
    private Map<String, String> clothes;
    private List<Person> friends;
}
