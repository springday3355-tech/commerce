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
        int total = 0; // 1. 합계를 저장할 변수를 0으로 시작함
        System.out.println("--- 장바구니 목록 ---");

        for(CartItem item : items) {
            System.out.println(item.getName() + " | " + item.getQuantity() + "개"); // 2. 바구니에 든 물건들 하나씩 보여주기
            total += (item.getPrice() * item.getQuantity()); // 가격 * 수량 계산해서 합계에 계속 더하기
        }
        // 4. 마지막에 총 금액 출력
        System.out.println("총 결제 금액: " + total + "원");
    }

}
