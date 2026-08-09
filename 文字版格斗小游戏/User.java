package 文字版格斗小游戏;

import java.util.Objects;

public class User {
    private String ID;// 用户ID
    private String name;// 用户名
    private String password;// 密码
    private String status = "ture";// 状态

    public User() {
    }

    public User( String name, String password) {
        this.name = name;
        this.password = password;
    }
    public String getID() {
        return ID;
    }

    public void setID(String  ID) {
        this.ID = ID;
    }


    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    // 重写equals方法
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(ID, user.ID) && Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(status, user.status);
    }


    // 重写toString方法
    public String toString() {
        return "User{ID = " + ID + ", name = " + name + ", password = " + password + ", status = " + status + "}";
    }
}
