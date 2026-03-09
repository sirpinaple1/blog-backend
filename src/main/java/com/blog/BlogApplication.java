package com.blog;

import com.blog.entity.*;
import com.blog.mapper.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.blog.mapper")
public class BlogApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
