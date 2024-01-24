package com.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;

    private double total;

    public Cart(){
        this.items = new ArrayList<>();
        this.total = 0.0;
    }

    public double getTotal() {
        return this.total = items.stream().mapToDouble(CartItem::getTotal).sum();
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}
