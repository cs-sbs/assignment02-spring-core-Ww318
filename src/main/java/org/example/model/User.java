package org.example.model;

/**
 * 用户模型类
 * 包含用户的基本信息：ID、用户名和邮箱
 */
public class User {
    private Long id;
    private String username;
    private String email;

    // 全参构造方法
    public User(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // Getter 和 Setter 方法
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // 重写 toString 方法，便于打印用户信息
    @Override
    public String toString() {
        return "User{id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' + '}';
    }
}