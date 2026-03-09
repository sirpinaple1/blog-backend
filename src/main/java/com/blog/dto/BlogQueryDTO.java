package com.blog.dto;

import lombok.Data;

@Data
public class BlogQueryDTO {
    private String title;
    private Long categoryId;
    private Integer status;
    private Integer isDraft;
}
