package com.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.entity.Blog;
import com.blog.mapper.BlogMapper;
import com.blog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
    
    @Override
    public IPage<Blog> pageBlogs(Integer pageNum, Integer pageSize, Blog query) {
        Page<Blog> page = new Page<>(pageNum, pageSize);
        return this.page(page);
    }
    
    @Override
    public Blog getBlogDetail(Long id) {
        return this.getById(id);
    }
    
    @Override
    public Blog saveBlog(Blog blog) {
        if (blog.getUserId() == null) {
            blog.setUserId(1L);
        }
        this.save(blog);
        return blog;
    }
    
    @Override
    public Blog updateBlog(Blog blog) {
        this.updateById(blog);
        return blog;
    }
    
    @Override
    public void deleteBlog(Long id) {
        this.removeById(id);
    }
    
    @Override
    public void updateViews(Long id) {
        Blog blog = this.getById(id);
        if (blog != null) {
            blog.setViews(blog.getViews() + 1);
            this.updateById(blog);
        }
    }
    
    @Override
    public void updateLikeCount(Long id) {
        Blog blog = this.getById(id);
        if (blog != null) {
            blog.setLikeCount(blog.getLikeCount() + 1);
            this.updateById(blog);
        }
    }
}
