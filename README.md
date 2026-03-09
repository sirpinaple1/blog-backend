# Blog System Backend

基于 Spring Boot + MyBatis Plus 的博客系统后端

## 技术栈

- Spring Boot 2.7.18
- MyBatis Plus 3.5.3
- MySQL 8.0
- JWT 认证
- SpringDoc OpenAPI (Swagger)

## 快速开始

### 1. 配置数据库

修改 `src/main/resources/application.yml`：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/blog_system
    username: root
    password: your_password
```

### 2. 初始化数据库

```bash
mysql -u root -p < src/main/resources/schema.sql
```

### 3. 启动项目

```bash
mvn spring-boot:run
```

### 4. 访问

- Swagger UI: http://localhost:8080/swagger-ui.html
- API 文档: http://localhost:8080/v3/api-docs

## API 接口

### 博客管理
- `GET /api/blog/page` - 分页查询博客
- `GET /api/blog/{id}` - 获取博客详情
- `POST /api/blog` - 新增博客
- `PUT /api/blog` - 更新博客
- `DELETE /api/blog/{id}` - 删除博客
- `POST /api/blog/{id}/like` - 点赞博客

### 分类管理
- `GET /api/category/list` - 获取所有分类
- `POST /api/category` - 新增分类
- `PUT /api/category` - 更新分类
- `DELETE /api/category/{id}` - 删除分类

### 评论管理
- `GET /api/comment/blog/{blogId}` - 获取博客评论
- `POST /api/comment` - 新增评论
- `DELETE /api/comment/{id}` - 删除评论

## 默认账号

- 用户名: admin
- 密码: admin123
