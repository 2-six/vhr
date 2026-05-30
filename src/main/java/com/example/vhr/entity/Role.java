package com.example.vhr.entity;

public class Role {
    private Integer id;
    private String name; // 角色名，如 ROLE_ADMIN
    private String nameZh; // 中文角色名

    // getter/setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getNameZh() { return nameZh; }
    public void setNameZh(String nameZh) { this.nameZh = nameZh; }
}