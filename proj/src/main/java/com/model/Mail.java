package com.model;

import java.io.Serializable;

public class Mail implements Serializable {
    private String to;

    private Cart cart;

    @Override
    public String toString() {
        return cart.toString();
    }

    public String getTo() {
        return to;
    }
}
