package com.example.food.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    STAFF_READ("creator:read"),
    STAFF_UPDATE("creator:update"),
    STAFF_CREATE("creator:create"),
    STAFF_DELETE("creator:delete"),

    CUSTOMER_READ("audience:read"),
    CUSTOMER_UPDATE("audience:update"),
    CUSTOMER_CREATE("audience:create"),
    CUSTOMER_DELETE("audience:delete"),


    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),


            ;
    @Getter
    private  final String permission;
}
