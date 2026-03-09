-- =============================================
-- 博客系统数据库脚本
-- =============================================

-- 创建数据库
CREATE DATABASE IF NOT EXISTS blog_system DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE blog_system;

-- =============================================
-- 用户表
-- =============================================
CREATE TABLE IF NOT EXISTS `user` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username` VARCHAR(50) NOT NULL COMMENT '用户名',
    `password` VARCHAR(100) NOT NULL COMMENT '密码',
    `nickname` VARCHAR(50) COMMENT '昵称',
    `avatar` VARCHAR(255) COMMENT '头像URL',
    `email` VARCHAR(100) COMMENT '邮箱',
    `role` VARCHAR(20) DEFAULT 'user' COMMENT '角色: admin/user',
    `status` TINYINT DEFAULT 1 COMMENT '状态: 0禁用 1正常',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- =============================================
-- 分类表
-- =============================================
CREATE TABLE IF NOT EXISTS `category` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name` VARCHAR(50) NOT NULL COMMENT '分类名称',
    `description` VARCHAR(255) COMMENT '描述',
    `sort` INT DEFAULT 0 COMMENT '排序',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分类表';

-- =============================================
-- 标签表
-- =============================================
CREATE TABLE IF NOT EXISTS `tag` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name` VARCHAR(50) NOT NULL COMMENT '标签名称',
    `color` VARCHAR(20) DEFAULT '#1890ff' COMMENT '标签颜色',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='标签表';

-- =============================================
-- 博客文章表
-- =============================================
CREATE TABLE IF NOT EXISTS `blog` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `title` VARCHAR(100) NOT NULL COMMENT '标题',
    `content` TEXT COMMENT '内容(Markdown)',
    `description` VARCHAR(500) COMMENT '摘要',
    `cover_image` VARCHAR(255) COMMENT '封面图',
    `category_id` BIGINT COMMENT '分类ID',
    `user_id` BIGINT NOT NULL COMMENT '作者ID',
    `views` INT DEFAULT 0 COMMENT '浏览量',
    `like_count` INT DEFAULT 0 COMMENT '点赞数',
    `comment_count` INT DEFAULT 0 COMMENT '评论数',
    `is_top` TINYINT DEFAULT 0 COMMENT '置顶: 0否 1是',
    `is_draft` TINYINT DEFAULT 0 COMMENT '草稿: 0否 1是',
    `status` TINYINT DEFAULT 1 COMMENT '状态: 0下架 1发布',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_category_id` (`category_id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='博客文章表';

-- =============================================
-- 博客标签关联表
-- =============================================
CREATE TABLE IF NOT EXISTS `blog_tag` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `blog_id` BIGINT NOT NULL COMMENT '博客ID',
    `tag_id` BIGINT NOT NULL COMMENT '标签ID',
    PRIMARY KEY (`id`),
    KEY `idx_blog_id` (`blog_id`),
    KEY `idx_tag_id` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='博客标签关联表';

-- =============================================
-- 评论表
-- =============================================
CREATE TABLE IF NOT EXISTS `comment` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `blog_id` BIGINT NOT NULL COMMENT '博客ID',
    `user_id` BIGINT COMMENT '用户ID(游客为null)',
    `parent_id` BIGINT COMMENT '父评论ID',
    `reply_to` BIGINT COMMENT '回复用户ID',
    `nickname` VARCHAR(50) COMMENT '游客昵称',
    `email` VARCHAR(100) COMMENT '游客邮箱',
    `content` VARCHAR(500) NOT NULL COMMENT '评论内容',
    `ip_address` VARCHAR(50) COMMENT 'IP地址',
    `status` TINYINT DEFAULT 1 COMMENT '状态: 0待审核 1通过',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_blog_id` (`blog_id`),
    KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论表';

-- =============================================
-- 初始化管理员账号 (密码: admin123)
-- =============================================
INSERT INTO `user` (`username`, `password`, `nickname`, `role`) 
VALUES ('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iAt6Z5EH', '管理员', 'admin');

-- =============================================
-- 初始化测试数据
-- =============================================
INSERT INTO `category` (`name`, `description`, `sort`) VALUES 
('技术分享', '技术相关文章', 1),
('生活随笔', '生活感悟', 2),
('项目经验', '项目总结', 3);

INSERT INTO `tag` (`name`, `color`) VALUES 
('Java', '#1890ff'),
('Spring Boot', '#52c41a'),
('Vue', '#722ed1'),
('MySQL', '#fa541c'),
('算法', '#13c2c2');

INSERT INTO `blog` (`title`, `content`, `description`, `category_id`, `user_id`, `views`, `status`) VALUES 
('Spring Boot 入门教程', '# Spring Boot 入门\n\n本文介绍 Spring Boot 的基本使用...', 'Spring Boot 入门教程，从零开始', 1, 1, 100, 1),
('Vue3 组件化开发', '# Vue3 组件化开发\n\nVue3 的组合式 API...', 'Vue3 组件化开发实战', 1, 1, 50, 1);
