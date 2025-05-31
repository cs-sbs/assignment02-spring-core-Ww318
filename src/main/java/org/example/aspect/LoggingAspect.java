package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 日志切面类
 * 使用AOP记录服务层方法的调用信息
 *
 * 关键注解：
 * @Aspect - 声明这是一个切面类
 * @Component - 让Spring管理这个切面组件
 */
@Aspect
@Component
public class LoggingAspect {

    // 使用SLF4J日志框架
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * 前置通知：在方法执行前记录日志
     *
     * 切点表达式解释：
     * execution(* org.example.service.UserService.*(..))
     * - 第一个 * : 匹配任意返回类型
     * - org.example.service.UserService : 目标类
     * - .* : 匹配任意方法
     * - (..) : 匹配任意参数
     */
    @Before("execution(* org.example.service.UserService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();

        // 获取方法参数
        Object[] args = joinPoint.getArgs();

        // 记录日志
        logger.info("[AOP-BEFORE] 调用方法: {}", methodName);
        logger.info("[AOP-BEFORE] 参数: {}", Arrays.toString(args));
    }

    /**
     * 返回后通知：在方法成功返回后记录日志
     *
     * @param joinPoint 连接点信息
     * @param result 方法返回值
     */
    @AfterReturning(
            pointcut = "execution(* org.example.service.UserService.*(..))",
            returning = "result"
    )
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();

        // 记录日志
        logger.info("[AOP-AFTER] 方法完成: {}", methodName);
        logger.info("[AOP-AFTER] 返回值: {}", result);
    }
}