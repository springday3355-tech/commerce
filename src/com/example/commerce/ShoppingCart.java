package com.example.commerce;


import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    // 1. 속성 / 물건들을 담을 실제 바구니
    private List<CartItem> items;

    // 2. 생성자 / 초기화
    public ShoppingCart(){
        this.items = new ArrayList<>();
    }
    // 3&4 기능
    // 3. 메서드 1 / - 상품추가
    public void addProduct(Product product, int quantity){
        // 새로운 장바구니 항목(CartItem) 생성
        CartItem newItem = new CartItem(product.getName(), product.getPrice(), quantity , product);
        items.add(newItem); // 바구니 리스트에 추가
        System.out.println(product.getName() + " " + quantity + "개가 장바구니에 담겼습니다.");

    }
    // 4. 메서드 2 / - 장바구니 보기
    public void displayCart(){
        System.out.println("--- 장바구니 목록 ---");
        for(CartItem item : items){
            System.out.println("상품명: " + item.getProduct().getName()
            + " | 수량: " + item.getQuantity()
            + " | 가격: " + (item.getProduct().getPrice() * item.getQuantity()) + "원");
        }
    }

}
