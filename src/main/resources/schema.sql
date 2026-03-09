-- 博客系统数据库表

CREATE TABLE IF NOT EXISTS `user` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username` VARCHAR(50) NOT NULL COMMENT '用户名',
    `password` VARCHAR(100) NOT NULL COMMENT '密码',
    `nickname` VARCHAR(50) COMMENT '昵称',
    `avatar` VARCHAR(255) COMMENT '头像URL',
    `email` VARCHAR(100) COMMENT '邮箱',
    `role` VARCHAR(20) DEFAULT 'user' COMMENT '角色',
    `status` TINYINT DEFAULT 1 COMMENT '状态',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

CREATE TABLE IF NOT EXISTS `category` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name` VARCHAR(50) NOT NULL COMMENT '分类名称',
    `description` VARCHAR(255) COMMENT '描述',
    `sort` INT DEFAULT 0 COMMENT '排序',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分类表';

CREATE TABLE IF NOT EXISTS `tag` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name` VARCHAR(50) NOT NULL COMMENT '标签名称',
    `color` VARCHAR(20) DEFAULT '#1890ff' COMMENT '标签颜色',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='标签表';

CREATE TABLE IF NOT EXISTS `blog` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `title` VARCHAR(100) NOT NULL COMMENT '标题',
    `content` TEXT COMMENT '内容',
    `description` VARCHAR(500) COMMENT '摘要',
    `cover_image` VARCHAR(255) COMMENT '封面图',
    `category_id` BIGINT COMMENT '分类ID',
    `user_id` BIGINT NOT NULL COMMENT '作者ID',
    `views` INT DEFAULT 0 COMMENT '浏览量',
    `like_count` INT DEFAULT 0 COMMENT '点赞数',
    `comment_count` INT DEFAULT 0 COMMENT '评论数',
    `is_top` TINYINT DEFAULT 0 COMMENT '置顶',
    `is_draft` TINYINT DEFAULT 0 COMMENT '草稿',
    `status` TINYINT DEFAULT 1 COMMENT '状态',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='博客表';

CREATE TABLE IF NOT EXISTS `comment` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `blog_id` BIGINT NOT NULL COMMENT '博客ID',
    `user_id` BIGINT COMMENT '用户ID',
    `parent_id` BIGINT COMMENT '父评论ID',
    `reply_to` BIGINT COMMENT '回复用户ID',
    `nickname` VARCHAR(50) COMMENT '昵称',
    `email` VARCHAR(100) COMMENT '邮箱',
    `content` VARCHAR(500) NOT NULL COMMENT '评论内容',
    `ip_address` VARCHAR(50) COMMENT 'IP地址',
    `status` TINYINT DEFAULT 1 COMMENT '状态',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论表';

-- 初始化管理员
INSERT INTO `user` (`username`, `password`, `nickname`, `role`) 
VALUES ('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iAt6Z5EH', '管理员', 'admin');

-- 初始化分类
INSERT INTO `category` (`name`, `description`, `sort`) VALUES 
('技术分享', '技术相关文章', 1),
('生活随笔', '生活感悟', 2);

-- 初始化标签
INSERT INTO `tag` (`name`, `color`) VALUES 
('Java', '#1890ff'),
('Vue', '#52c41a');

-- 初始化博客
INSERT INTO `blog` (`title`, `content`, `description`, `category_id`, `user_id`, `views`, `status`) VALUES 
('欢迎来到我的博客', '# 欢迎\n\n这是我的第一篇博客！', '欢迎访问', 1, 1, 0, 1);
