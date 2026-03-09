package com.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;

@TableName("category")
public class Category {
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private String name;
    private String description;
    private Integer sort;
    
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Integer getSort() { return sort; }
    public void setSort(Integer sort) { this.sort = sort; }
    
    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
}
