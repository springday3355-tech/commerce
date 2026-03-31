package com.example.commerce;
import java.util.ArrayList;
import java.util.List;
public class ShoppingCart {
    // 1. 속성 / 물건들을 담을 실제 바구니
    private static List<CartItem> items;

    // 2. 생성자 / 초기화
    public ShoppingCart(){
        this.items = new ArrayList<>();
    }
    // 3&4 기능
    // 3. 메서드 1 / 상품추가
    public static void addProduct(Product product, int quantity){
        // 재고 줄이라고 명령
        product.reduceStock(quantity);
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
            System.out.println(item.getName() + " | " + item.getPrice() + " 원 | " + item.getQuantity() + "개"); // 2. 바구니에 든 물건들 하나씩 보여주기
            total += (item.getPrice() * item.getQuantity()); // 가격 * 수량 계산해서 합계에 계속 더하기
            // (가격 * 수량)을 계산해서 총액에 누적해서 더함 /  total += 의미: total = total + (새로운 값)의 줄임말
            total += (item.getPrice() * item.getQuantity());
        }
        // 4. 마지막에 총 금액 출력
        System.out.println("----------------");
        System.out.println("총 결제 금액: " + total + "원");
    }
    public void order(){
        if(items.isEmpty()){// 장바구니 비어있는지 확인
            System.out.println("장바구니가 비어 있어 주문할 수 없습니다.");
            return;
        }
        // 주문 완료 메세지 출력
        System.out.println("주문이 완료되었습니다. 이용해 주셔서 감사합니다.");
        // 장바구니 비우기
        items.clear();
    }


}
