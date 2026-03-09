package com.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;

@TableName("comment")
public class Comment {
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private Long blogId;
    private Long userId;
    private Long parentId;
    private Long replyTo;
    private String nickname;
    private String email;
    private String content;
    private String ipAddress;
    private Integer status;
    
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getBlogId() { return blogId; }
    public void setBlogId(Long blogId) { this.blogId = blogId; }
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    
    public Long getParentId() { return parentId; }
    public void setParentId(Long parentId) { this.parentId = parentId; }
    
    public Long getReplyTo() { return replyTo; }
    public void setReplyTo(Long replyTo) { this.replyTo = replyTo; }
    
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
    
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    
    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
}
