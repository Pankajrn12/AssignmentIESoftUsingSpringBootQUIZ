package com.sandy.student.enums;

public enum Status {
    Active("Active"),
    Inactive("Inactive");

    Status(String description) {
        this.description = description;
    }

    private String description;
}
