package com.muniao.springsecuritydemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "testlist")
@Data
public class TestListConfig
{
    private List<String> servers = new ArrayList<>();
}
