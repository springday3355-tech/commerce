package com.example.commerce;

public class CartItem {
    // 속성
    private String name;
    private int price;
    private int quantity;
    private Product product;

    // 생성자
    public CartItem(String name, int price, int quantity, Product product){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.product = product;
    }
    // 기능(게터)
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getQuantity() {return quantity;}
    public Product getProduct() {return product;}
}
