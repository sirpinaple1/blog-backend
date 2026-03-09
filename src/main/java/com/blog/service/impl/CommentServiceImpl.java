package com.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.blog.entity.Comment;
import com.blog.mapper.CommentMapper;
import com.blog.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    
    @Override
    public List<Comment> listByBlogId(Long blogId) {
        LambdaQueryWrapper<Comment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Comment::getBlogId, blogId)
               .eq(Comment::getStatus, 1)
               .orderByAsc(Comment::getCreateTime);
        return this.list(wrapper);
    }
    
    @Override
    @Transactional
    public void saveComment(Comment comment) {
        this.save(comment);
    }
}
