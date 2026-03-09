package com.blog.controller;

import com.blog.common.Result;
import com.blog.entity.Tag;
import com.blog.service.TagService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagController {
    
    @Autowired
    private TagService tagService;
    
    @Operation(summary = "获取所有标签")
    @GetMapping("/list")
    public Result<List<Tag>> list() {
        return Result.success(tagService.list());
    }
    
    @Operation(summary = "获取标签详情")
    @GetMapping("/{id}")
    public Result<Tag> detail(@PathVariable Long id) {
        return Result.success(tagService.getById(id));
    }
    
    @Operation(summary = "新增标签")
    @PostMapping
    public Result<Tag> save(@RequestBody Tag tag) {
        tagService.save(tag);
        return Result.success(tag);
    }
    
    @Operation(summary = "更新标签")
    @PutMapping
    public Result<Tag> update(@RequestBody Tag tag) {
        tagService.updateById(tag);
        return Result.success(tag);
    }
    
    @Operation(summary = "删除标签")
    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        tagService.removeById(id);
        return Result.success();
    }
}
