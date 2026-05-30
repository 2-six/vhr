package com.example.vhr.entity;

import java.util.List;

public class Menu {
    private Integer id;
    private String url;
    private String path;
    private String component;
    private String name;
    private String icon;
    private Integer parentId;
    private Boolean enabled;

    // 子菜单
    private List<Menu> children;
    // 能访问该菜单的角色
    private List<Role> roles;

    // getter/setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }
    public String getComponent() { return component; }
    public void setComponent(String component) { this.component = component; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }
    public Integer getParentId() { return parentId; }
    public void setParentId(Integer parentId) { this.parentId = parentId; }
    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }
    public List<Menu> getChildren() { return children; }
    public void setChildren(List<Menu> children) { this.children = children; }
    public List<Role> getRoles() { return roles; }
    public void setRoles(List<Role> roles) { this.roles = roles; }
}