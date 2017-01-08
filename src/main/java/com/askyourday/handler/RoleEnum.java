package com.askyourday.handler;

public enum RoleEnum {
    USER(1L, "user"),
    ADMIN(2L, "admin");

    private Long id;
    private String roleName;

    RoleEnum(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
