package com.blog;

import com.blog.entity.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.blog.mapper.*;

@SpringBootApplication
@MapperScan("com.blog.mapper")
public class BlogApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner initDatabase(
            UserMapper userMapper,
            CategoryMapper categoryMapper,
            TagMapper tagMapper,
            BlogMapper blogMapper,
            CommentMapper commentMapper
    ) {
        return args -> {
            // 尝试查询，如果表不存在会抛异常
            try {
                userMapper.selectCount(null);
                categoryMapper.selectCount(null);
            } catch (Exception e) {
                // 表不存在，创建示例数据
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword("$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iAt6Z5EH");
                admin.setNickname("管理员");
                admin.setRole("admin");
                userMapper.insert(admin);
                
                Category c1 = new Category();
                c1.setName("技术分享");
                c1.setDescription("技术相关文章");
                categoryMapper.insert(c1);
                
                Tag t1 = new Tag();
                t1.setName("Java");
                t1.setColor("#1890ff");
                tagMapper.insert(t1);
            }
        };
    }
}
