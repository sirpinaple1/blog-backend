package com.blog.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseInitConfig {
    
    @Bean
    public CommandLineRunner initTables() {
        return args -> {
            // MyBatis-Plus 会在启动时自动创建表
            // 如果表不存在，会根据实体类自动创建
        };
    }
}
