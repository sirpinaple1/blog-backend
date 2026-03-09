package com.blog.controller;

import com.blog.common.Result;
import com.blog.entity.Comment;
import com.blog.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "评论管理")
@RestController
@RequestMapping("/api/comment")
public class CommentController {
    
    @Autowired
    private CommentService commentService;
    
    @Operation(summary = "获取博客评论")
    @GetMapping("/blog/{blogId}")
    public Result<List<Comment>> listByBlog(@PathVariable Long blogId) {
        return Result.success(commentService.listByBlogId(blogId));
    }
    
    @Operation(summary = "新增评论")
    @PostMapping
    public Result<Comment> save(@RequestBody Comment comment) {
        commentService.saveComment(comment);
        return Result.success(comment);
    }
    
    @Operation(summary = "删除评论")
    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        commentService.removeById(id);
        return Result.success();
    }
}
