package com.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.blog.entity.Tag;
import com.blog.mapper.TagMapper;
import com.blog.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
    
    @Override
    public List<Tag> getTagsByBlogId(Long blogId) {
        // TODO: 实现博客标签查询
        return this.list();
    }
    
    @Override
    @Transactional
    public void saveBlogTags(Long blogId, List<Long> tagIds) {
        // TODO: 实现博客标签保存
    }
}
