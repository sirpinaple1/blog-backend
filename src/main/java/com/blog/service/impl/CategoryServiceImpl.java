package com.blog.service.impl;

import com.blog.entity.Category;
import com.blog.mapper.CategoryMapper;
import com.blog.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
