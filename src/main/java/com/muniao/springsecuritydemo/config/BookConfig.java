package com.muniao.springsecuritydemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "book")
@Data
public class BookConfig
{
    private Long id;
    private String name;
    private String author;
}
