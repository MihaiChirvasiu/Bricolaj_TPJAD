package com.model;

public class CartItem {
    private Product product;
    private int pieces;
    private double total;

    public CartItem(Product product, int pieces) {
        this.product = product;
        this.pieces = pieces;
        this.total = product.getPrice() * pieces;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }
}
