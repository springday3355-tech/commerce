package com.example.commerce;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CommerceSystem {
    // 1. 장바구니 상품추가
    ShoppingCart cart = new ShoppingCart();


    private Customer currentCustomer;

    public CommerceSystem() {
        // 생성자는 비워두거나 super() 호출 가능
    }

    public void start() {
        // 1. 고객 및 상품 데이터 초기화
        currentCustomer = new Customer("송이", "springday3355@gmail.com", "VIP");
        Product p1 = new Product("Galaxy S26", 1200000, "최신 안드로이드 스마트폰", 24);
        Product p2 = new Product("iPhone 17", 1350000, "Apple의 최신 스마트폰", 17);
        Product p3 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 8);
        Product p4 = new Product("AirPods Pro 3", 350000, "노이즈 캔슬링 무선 이어폰", 35);

        Category currentCategory = new Category("전자제품");
        currentCategory.addProduct(p1);
        currentCategory.addProduct(p2);
        currentCategory.addProduct(p3);
        currentCategory.addProduct(p4);

        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###");

        while (true) {
            System.out.println("\n[ 실시간 커머스 플랫폼 메인 ]");
            System.out.println("1." + currentCategory.getCategoryName());
            System.out.println("2. 의류");
            System.out.println("3. 식품");
            System.out.println("0. 종료 | 프로그램 종료");
            System.out.print("입력: ");
            int mainChoice = sc.nextInt();

            if (mainChoice == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }



            if (mainChoice == 1) {
                while (true) {
                    System.out.println("\n[" + currentCategory.getCategoryName() + " 카테고리 ]");
                    int index = 1;
                    for (Product product : currentCategory.getProducts()) {
                        System.out.println(index + "." + product.getName() + " | " +
                                df.format(product.getPrice()) + " 원 | " + product.getDescription());
                        index++;
                    }
                    System.out.println("0. 뒤로가기");
                    System.out.print("입력: ");

                    int productChoice = sc.nextInt();

                    if (productChoice == 0) break;

                    if (productChoice < 1 || productChoice > currentCategory.getProducts().size()){
                        System.out.println("유효하지  않은 상품 번호입니다 다시 선택해주세요");
                        continue;
                    }

                    if (productChoice > 0 ) {
                        Product selectedProduct = currentCategory.getProducts().get(productChoice - 1);
                        // 장바구니에 추가(아래)
                        cart.addProduct(selectedProduct, 1);
                        System.out.println("\n[상품 상세 정보]");
                        System.out.println("명칭: " + selectedProduct.getName());
                        System.out.println("가격: " + df.format(selectedProduct.getPrice()) + "원");
                        System.out.println("설명: " + selectedProduct.getDescription());
                        System.out.println("재고: " + selectedProduct.getStock() + "개");
                        System.out.println("--------------------------");
                    } else {
                        System.out.println("번호를 다시 확인해주세요.");
                    }

                }
            } else if (mainChoice == 2 || mainChoice == 3) {
                System.out.println("준비 중인 카테고리입니다.");
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    } // start() 메서드 종료

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }
    }// CommerceSystem 클래스 종료