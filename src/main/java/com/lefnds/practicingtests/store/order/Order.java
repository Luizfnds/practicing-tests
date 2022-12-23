package com.lefnds.practicingtests.store.order;

public class Order {

    private String userId;

    public Order(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String id) {
        this.userId = id;
    }
}
