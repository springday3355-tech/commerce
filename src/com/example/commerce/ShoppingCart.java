package com.example.commerce;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.*;

public class ShoppingCart {
    // 1. 속성 / 물건들을 담을 실제 바구니
    private static Map<String, CartItem> itemsMap = new HashMap<>();

    // 2. 생성자 / 초기화
    public ShoppingCart() {
        this.itemsMap = new HashMap<>();
    }

    public boolean isEmpty() {
        return itemsMap.isEmpty();
    }

    public static List<CartItem> getItems() {
        return new ArrayList<>(itemsMap.values());
    }

    // 3&4 기능
    // 3. 메서드 1 / 상품추가
    public void addProduct(Product product, int quantity) {
        String name = product.getName();

        // 재고확인
        if(product.getStock() < quantity){
            out.println("죄송합니다. " + name + "의 재고가 부족합니다.");
            return;
        }
        // 재고차감
        product.reduceStock(quantity);
        // itemsMap에 이미 있는지 확인
        if(itemsMap.containsKey(name)){
            // 이미 있다면 -> 기존 CartItem꺼내 수량만 더함
            CartItem existingItem = itemsMap.get(name);
            existingItem.addQuantity(quantity);
        } else {
            // 처음 만든다면 -> 새로만들어서 넣음
            CartItem newItem = new CartItem(name, product.getPrice(), quantity,product);
            itemsMap.put(name, newItem);
        }
        out.println(name + " " + quantity + "  개가 장바구니에 담겼습니다.");
    }


    // 4. 메서드 2 / - 장바구니 보기
    public void displayCart() {
        int total = 0; // 1. 합계를 저장할 변수를 0으로 시작함
        out.println("--- 장바구니 목록 ---");

        for (CartItem item : itemsMap.values()) { //Map안의 CartItem들만 리스트처럼 뽑을 수 있음
            out.println(item.getName() + " | " + item.getPrice() + " 원 | " + item.getQuantity() + "개"); // 2. 바구니에 든 물건들 하나씩 보여주기
            total += (item.getPrice() * item.getQuantity()); // 가격 * 수량 계산해서 합계에 계속 더하기
            // (가격 * 수량)을 계산해서 총액에 누적해서 더함 /  total += 의미: total = total + (새로운 값)의 줄임말
        }
        // 4. 마지막에 총 금액 출력
        out.println("----------------");
        out.println("총 결제 금액: " + total + "원");
    }

    public void order() {
        if (itemsMap.isEmpty()) {// 장바구니 비어있는지 확인
            out.println("장바구니가 비어 있어 주문할 수 없습니다.");
            return;
        }
        // 1. 주문 완료전 총 금액 계산
        int total = 0;
        for (CartItem item : itemsMap.values()){
            total += (item.getPrice() * item.getQuantity());
        }
            // 2. 계산된 total 출력
            out.println("주문이 완료되었습니다! 총 금액: " + total + "원");
            // 3. 주문 끝났으니 비우기
            itemsMap.clear();
        }

    }