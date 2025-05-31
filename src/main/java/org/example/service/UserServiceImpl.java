package org.example.service;

import org.example.model.User;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 * 实现用户管理系统的核心业务逻辑
 * 使用 @Service 注解标记为 Spring 管理的服务组件
 */
@Service("userService") // 指定Bean名称为"userService"
public class UserServiceImpl implements UserService {

    // 模拟用户ID生成器
    private long userIdCounter = 1000;

    @Override
    public User createUser(String username, String email) {
        // 生成用户ID（实际应用中应由数据库生成）
        Long id = ++userIdCounter;

        // 创建用户对象
        User newUser = new User(id, username, email);

        // 模拟数据库保存操作
        System.out.println("保存用户到数据库: " + newUser);

        return newUser;
    }

    @Override
    public User getUserById(Long id) {
        // 模拟数据库查询操作
        System.out.println("从数据库查询用户ID: " + id);

        // 返回模拟用户数据
        return new User(id, "user" + id, "user" + id + "@example.com");
    }

    @Override
    public void deleteUser(Long id) {
        // 模拟数据库删除操作
        System.out.println("从数据库删除用户ID: " + id);
    }
}