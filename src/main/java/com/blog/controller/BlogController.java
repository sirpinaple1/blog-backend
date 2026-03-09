package com.blog.controller;

import com.blog.common.Result;
import com.blog.entity.Blog;
import com.blog.service.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "博客管理")
@RestController
@RequestMapping("/api/blog")
public class BlogController {
    
    @Autowired
    private BlogService blogService;
    
    @Operation(summary = "获取所有博客")
    @GetMapping("/list")
    public Result<List<Blog>> list() {
        List<Blog> blogs = blogService.list();
        return Result.success(blogs);
    }
    
    @Operation(summary = "分页查询博客")
    @GetMapping("/page")
    public Result<List<Blog>> page(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        List<Blog> blogs = blogService.list();
        return Result.success(blogs);
    }
    
    @Operation(summary = "获取博客详情")
    @GetMapping("/{id}")
    public Result<Blog> detail(@PathVariable Long id) {
        Blog blog = blogService.getBlogDetail(id);
        return Result.success(blog);
    }
    
    @Operation(summary = "新增博客")
    @PostMapping
    public Result<Blog> save(@RequestBody Blog blog) {
        blogService.saveBlog(blog);
        return Result.success(blog);
    }
    
    @Operation(summary = "更新博客")
    @PutMapping
    public Result<Blog> update(@RequestBody Blog blog) {
        blogService.updateBlog(blog);
        return Result.success(blog);
    }
    
    @Operation(summary = "删除博客")
    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return Result.success();
    }
    
    @Operation(summary = "点赞博客")
    @PostMapping("/{id}/like")
    public Result<Void> like(@PathVariable Long id) {
        blogService.updateLikeCount(id);
        return Result.success();
    }
}
