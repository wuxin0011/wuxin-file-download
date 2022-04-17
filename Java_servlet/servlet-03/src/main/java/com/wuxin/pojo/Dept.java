package com.wuxin.pojo;

/**
 * @Author: wuxin001
 * @Date: 2022/04/16/22:44
 * @Description: 部门实体类
 */
public class Dept {

    private int id;
    private String name;
    private String description;
    private boolean status;
    private boolean isDel;

    public Dept(int id, String name, String description, boolean status, boolean isDel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.isDel = isDel;
    }

    public Dept() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean del) {
        isDel = del;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", isDel=" + isDel +
                '}';
    }
}
