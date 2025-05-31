package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Spring应用配置类
 *
 * 关键注解：
 * @Configuration - 声明这是一个Spring配置类
 * @ComponentScan - 自动扫描指定包下的组件
 * @EnableAspectJAutoProxy - 启用Spring的AOP代理功能
 */
@Configuration
@ComponentScan(basePackages = "org.example") // 扫描org.example包及其子包
@EnableAspectJAutoProxy // 启用AspectJ自动代理
public class AppConfig {
    /*
     * 使用Java配置类代替XML配置的优势：
     * 1. 类型安全 - 编译时检查配置错误
     * 2. 更好的重构支持
     * 3. 配置集中管理
     * 4. 避免XML配置的繁琐
     */
}