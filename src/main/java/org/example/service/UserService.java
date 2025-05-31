package org.example.service;

import org.example.model.User;

/**
 * 用户服务接口
 * 定义用户管理系统的核心功能
 */
public interface UserService {

    /**
     * 创建新用户
     * @param username 用户名
     * @param email 用户邮箱
     * @return 创建的用户对象
     */
    User createUser(String username, String email);

    /**
     * 根据ID获取用户
     * @param id 用户ID
     * @return 对应的用户对象
     */
    User getUserById(Long id);

    /**
     * 根据ID删除用户
     * @param id 用户ID
     */
    void deleteUser(Long id);
}