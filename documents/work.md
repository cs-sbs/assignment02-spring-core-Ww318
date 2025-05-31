# Spring IoC 和 AOP 实践报告

## 应用场景
实现一个简单的用户管理系统，包含以下功能：
-用户创建
-用户查询
-用户删除
通过Spring IoC管理组件依赖关系，使用AOP实现方法调用日志记录。

## 项目结构规划

src/
├── main/
│   ├── java/
│   │   └── org/example/
│   │       ├── Main.java              # 主测试类
│   │       ├── config/AppConfig.java  # Spring配置
│   │       ├── service/               # 服务层
│   │       │   ├── UserService.java
│   │       │   └── UserServiceImpl.java
│   │       ├── aspect/                # 切面层
│   │       │   └── LoggingAspect.java
│   │       └── model/                 # 模型层
│   │           └── User.java
│   └── resources/                     # 资源文件
└── test/                              # 测试代码（可选）

## IoC 实现方式
使用**注解方式**实现IoC容器：
- `@Configuration`：标记配置类
- `@ComponentScan`：自动扫描组件
- `@Service`：标记服务层组件
- `@Component`：标记切面组件

## AOP 实现方式
使用**注解方式**实现AOP：
- `@Aspect`：标记切面类
- `@Before`：前置通知
- `@AfterReturning`：返回后通知
- `execution`：定义切点表达式

## 关键代码说明

### 1. Spring配置类
```java
@Configuration
@ComponentScan(basePackages = "org.example")
@EnableAspectJAutoProxy
public class AppConfig {}

