package com.heima.学生管理系统;

import java.util.Scanner;

public class xuesheng {
    private String id;
    private String name;
    private int age;
    private String zhuzhi;
    Scanner scanner = new Scanner(System.in);

    public xuesheng() {
    }

    public xuesheng(String id, String name, int age, String zhuzhi) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.zhuzhi = zhuzhi;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId() {
        this.id = scanner.nextLine();
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
    public void setName() {
        this.name = scanner.nextLine();
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge() {
        this.age = scanner.nextInt();
        scanner.nextLine();
    }

    /**
     * 获取
     * @return zhuzhi
     */
    public String getZhuzhi() {
        return zhuzhi;
    }

    /**
     * 设置
     * @param zhuzhi
     */
    public void setZhuzhi() {
        this.zhuzhi = scanner.nextLine();
    }

    public String toString() {
        return "xuesheng{id = " + id + ", name = " + name + ", age = " + age + ", zhuzhi = " + zhuzhi + "}";
    }
}
