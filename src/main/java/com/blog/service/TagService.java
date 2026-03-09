package com.blog.service;

import com.blog.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

public interface TagService extends IService<Tag> {
    
    List<Tag> getTagsByBlogId(Long blogId);
    
    void saveBlogTags(Long blogId, List<Long> tagIds);
}
