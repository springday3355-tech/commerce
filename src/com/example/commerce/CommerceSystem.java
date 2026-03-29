package com.example.commerce;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CommerceSystem {

    // 속성 : 이제 개별 리스트가 아니라 카테고리로 관리함
    private Category currentCategory; // 예시로 하나의 카테고리만 관리한다고 가정함
    private Customer currentCustomer; // 시스템 사용자


    // 생성자 : 인자 없는 기본생성자로 변경 or 내부 초기화
    public CommerceSystem(){
        // 초기화는 start에서

    }


    // 기능
    public void start(){
        // 1. 고객생성
        currentCustomer = new Customer("송이", "springday3355@gmail.com","VIP");

        // 2. 상품생성 및 카테고리 조립 **핵심**

        Product p1 = new Product("Galaxy S26" , 1200000 , "최신 안드로이드 스마트폰", 24);
        Product p2 = new Product("iPhone 17", 1350000, "Apple의 최신 스마트폰", 17);
        Product p3 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 8);
        Product p4 = new Product("AirPods Pro 3", 350000, "노이즈 캔슬링 무선 이어폰", 35);

        // 3. 카테고리 생성 및 상품 추가
        currentCategory = new Category("전자제품");
        currentCategory.addProduct(p1);
        currentCategory.addProduct(p2);
        currentCategory.addProduct(p3);
        currentCategory.addProduct(p4);

        // 4. UI 상호작용
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###");


        while(true){
            // 카테고리 이름 가져와서 출력
            System.out.println("[실시간 커머스 플랫폼"+ currentCategory.getCategoryName() + "]");
            // 카테고리에서 상품목록 출력
            int index = 1;
            // **currentCategory.getProducts()를 사용!**
            for (Product product : currentCategory.getProducts()) { //목록 출력
                // Product가 private이므로 게터 사용
                System.out.println(index + "." + product.getName + " | "+
                        df.format(product.getPrice())+ " 원 | " + product.getDescription());
                index++; // 무한 반복 방지
            }

            System.out.println("0. 종료 | 프로그램 종료");
            System.out.println("입력: ");
            int choice = sc.nextInt();// 번호 입력받기

            if(choice == 0){
                System.out.println("커머스 플랫폼을 종료합니다ㅣ.");
                break; // 0이면 종료됨
            }
            // choice가 0이 아닐 때 실행될 부분 + getter사용
            if (choice > 0 && choice <= currentCategory.getProducts().size()){
                Product selectedProduct = currentCategory.getProducts().get(choice -1); // 사용자가 1입력하면 products.get(0)을 가져온다

                System.out.println("\n[상품 상세 정보]");
                System.out.println("명칭: " + selectedProduct.getName()); // 1~4 상세정보 출력
                System.out.println("가격: " + df.format(selectedProduct.getPrice()) + "원");
                System.out.println("설명: " + selectedProduct.getDescription());
                System.out.println("재고: " + selectedProduct.getStock() + "개");
                System.out.println("--------------------------");

            } else { // 0~4 외 숫자들 에러메세지출력
                System.out.println("해당하는 상품 번호가 없습니다. 다시 입력해주세요.");


            }
        }

    }


}
