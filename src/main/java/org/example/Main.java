package org.example;

import org.example.config.AppConfig;
import org.example.model.User;
import org.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 主测试类
 * 用于验证Spring IoC和AOP的功能
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // 初始化日志
        logger.info("===== Spring IoC & AOP 测试程序开始 =====");

        // 1. 创建Spring应用上下文（基于Java配置）
        // 使用AnnotationConfigApplicationContext加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        logger.info("Spring容器初始化完成");

        // 2. 从容器中获取UserService bean
        // 演示IoC容器的依赖注入功能
        UserService userService = context.getBean("userService", UserService.class);
        logger.info("成功获取UserService实例: {}", userService.getClass().getName());

        // 3. 测试创建用户功能
        logger.info("\n===== 测试创建用户 =====");
        User newUser = userService.createUser("john_doe", "john@example.com");
        logger.info("创建的用户: {}", newUser);

        // 4. 测试获取用户功能
        logger.info("\n===== 测试获取用户 =====");
        User foundUser = userService.getUserById(1001L);
        logger.info("获取的用户: {}", foundUser);

        // 5. 测试删除用户功能
        logger.info("\n===== 测试删除用户 =====");
        userService.deleteUser(1002L);
        logger.info("删除用户操作完成");

        // 6. 验证AOP是否正常工作
        logger.info("\n===== AOP验证 =====");
        logger.info("请检查控制台输出，应包含AOP日志记录");

        // 结束程序
        logger.info("\n===== 测试程序结束 =====");
    }
}