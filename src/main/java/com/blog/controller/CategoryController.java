package com.blog.controller;

import com.blog.common.Result;
import com.blog.entity.Category;
import com.blog.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "分类管理")
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    @Operation(summary = "获取所有分类")
    @GetMapping("/list")
    public Result<List<Category>> list() {
        return Result.success(categoryService.list());
    }
    
    @Operation(summary = "获取分类详情")
    @GetMapping("/{id}")
    public Result<Category> detail(@PathVariable Long id) {
        return Result.success(categoryService.getById(id));
    }
    
    @Operation(summary = "新增分类")
    @PostMapping
    public Result<Category> save(@RequestBody Category category) {
        categoryService.save(category);
        return Result.success(category);
    }
    
    @Operation(summary = "更新分类")
    @PutMapping
    public Result<Category> update(@RequestBody Category category) {
        categoryService.updateById(category);
        return Result.success(category);
    }
    
    @Operation(summary = "删除分类")
    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        categoryService.removeById(id);
        return Result.success();
    }
}
