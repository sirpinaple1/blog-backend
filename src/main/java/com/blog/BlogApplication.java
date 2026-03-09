package com.blog;

import com.blog.entity.*;
import com.blog.mapper.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@MapperScan("com.blog.mapper")
public class BlogApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner initTables(JdbcTemplate jdbc) {
        return args -> {
            try {
                jdbc.execute("CREATE TABLE IF NOT EXISTS `user` (" +
                    "`id` BIGINT NOT NULL AUTO_INCREMENT," +
                    "`username` VARCHAR(50) NOT NULL," +
                    "`password` VARCHAR(100) NOT NULL," +
                    "`nickname` VARCHAR(50)," +
                    "`role` VARCHAR(20) DEFAULT 'user'," +
                    "`status` INT DEFAULT 1," +
                    "`create_time` DATETIME DEFAULT CURRENT_TIMESTAMP," +
                    "PRIMARY KEY (`id`)" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4");
                
                jdbc.execute("CREATE TABLE IF NOT EXISTS `category` (" +
                    "`id` BIGINT NOT NULL AUTO_INCREMENT," +
                    "`name` VARCHAR(50) NOT NULL," +
                    "`description` VARCHAR(255)," +
                    "`sort` INT DEFAULT 0," +
                    "`create_time` DATETIME DEFAULT CURRENT_TIMESTAMP," +
                    "PRIMARY KEY (`id`)" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4");
                
                jdbc.execute("CREATE TABLE IF NOT EXISTS `tag` (" +
                    "`id` BIGINT NOT NULL AUTO_INCREMENT," +
                    "`name` VARCHAR(50) NOT NULL," +
                    "`color` VARCHAR(20) DEFAULT '#1890ff'," +
                    "`create_time` DATETIME DEFAULT CURRENT_TIMESTAMP," +
                    "PRIMARY KEY (`id`)" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4");
                
                jdbc.execute("CREATE TABLE IF NOT EXISTS `blog` (" +
                    "`id` BIGINT NOT NULL AUTO_INCREMENT," +
                    "`title` VARCHAR(100) NOT NULL," +
                    "`content` TEXT," +
                    "`description` VARCHAR(500)," +
                    "`category_id` BIGINT," +
                    "`user_id` BIGINT NOT NULL," +
                    "`views` INT DEFAULT 0," +
                    "`like_count` INT DEFAULT 0," +
                    "`comment_count` INT DEFAULT 0," +
                    "`is_top` INT DEFAULT 0," +
                    "`is_draft` INT DEFAULT 0," +
                    "`status` INT DEFAULT 1," +
                    "`create_time` DATETIME DEFAULT CURRENT_TIMESTAMP," +
                    "`update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP," +
                    "PRIMARY KEY (`id`)" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4");
            } catch (Exception e) {
                // 表可能已存在
            }
        };
    }
}
