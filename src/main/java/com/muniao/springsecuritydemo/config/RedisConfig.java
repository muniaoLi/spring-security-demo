package com.muniao.springsecuritydemo.config;

import com.muniao.springsecuritydemo.domain.SingleRedisConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisConfig
{
    private List<SingleRedisConfig> redisConfigs;
}
