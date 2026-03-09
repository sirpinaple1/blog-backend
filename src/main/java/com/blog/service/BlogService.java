package com.blog.service;

import com.blog.entity.Blog;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BlogService extends IService<Blog> {
    
    IPage<Blog> pageBlogs(Integer pageNum, Integer pageSize, Blog query);
    
    Blog getBlogDetail(Long id);
    
    Blog saveBlog(Blog blog);
    
    Blog updateBlog(Blog blog);
    
    void deleteBlog(Long id);
    
    void updateViews(Long id);
    
    void updateLikeCount(Long id);
}
