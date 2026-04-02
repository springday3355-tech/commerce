package com.example.commerce;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class CommerceSystem {
    // 1. 장바구니 상품추가
    private final ShoppingCart shoppingCart = new ShoppingCart();
    private final Scanner sc = new Scanner(System.in);

    private Customer currentCustomer;
    private Administrator administrator = new Administrator();
    private Category Category;
    private Category currentCategory;

    public CommerceSystem() {
        // 생성자는 비워두거나 super() 호출 가능
    }
    public void start() {
        // 1. 고객 및 데이터 초기화
        currentCustomer = new Customer("송이", "springday3355@gmail.com", "VIP");
        System.out.println(currentCustomer.getName() + "님, 환영합니다!" + ( currentCustomer.getGrade() + " 등급"));
        Product p1 = new Product("Galaxy S26", 1200000, "최신 안드로이드 스마트폰", 10);
        Product p2 = new Product("iPhone 17", 1350000, "Apple의 최신 스마트폰", 17);
        Product p3 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 8);
        Product p4 = new Product("AirPods Pro 3", 350000, "노이즈 캔슬링 무선 이어폰", 4);

        Category currentCategory = new Category(" 전자제품");
        currentCategory.addProduct(p1);
        currentCategory.addProduct(p2);
        currentCategory.addProduct(p3);
        currentCategory.addProduct(p4);

        DecimalFormat df = new DecimalFormat("#,###");

        while (true) {
            System.out.println("\n[ 실시간 커머스 플랫폼 메인 ]");
            System.out.println("1." + currentCategory.getCategoryName());
            System.out.println("2. 의류");
            System.out.println("3. 식품");
            System.out.println("4. 장바구니 보기");
            System.out.println("0. 종료 | 프로그램 종료");
            System.out.println("6. 관리자 모드");
            System.out.print("입력: ");

            //  수정 1: 메인 메뉴 번호를 먼저 받아야 함
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

                    // 3번 예외처리: 목록 범위를 벗어난 경우
                    if (productChoice < 1 || productChoice > currentCategory.getProducts().size()) {
                        System.out.println("️ 유효하지 않은 상품 번호입니다. 다시 선택해주세요.");
                        continue;
                    }
                    // 수정 2: 상품 상세 정보 보여주기
                    Product selectedProduct = currentCategory.getProducts().get(productChoice - 1);
                    System.out.println("\n[상품 상세 정보]");
                    System.out.println("명칭: " + selectedProduct.getName());
                    System.out.println("가격: " + df.format(selectedProduct.getPrice()) + "원");
                    System.out.println("설명: " + selectedProduct.getDescription());
                    System.out.println("재고: " + selectedProduct.getStock() + "개");
                    System.out.println("--------------------------");

                    // 수정 3: 상세 정보 본 후에 "담기/취소" 물어보기
                    System.out.println("장바구니에 추가하시겠습니까? (1.추가 / 2.취소)");
                    int cartChoice = sc.nextInt();

                    if (cartChoice == 1) {
                        shoppingCart.addProduct(selectedProduct, 1);
                    } else if (cartChoice == 2) {
                        System.out.println("취소 되었습니다.");
                    } else {
                        System.out.println("잘못된 입력입니다.");
                    }
                //장바구니 목록 & 총액
                shoppingCart.displayCart();

                if(!shoppingCart.isEmpty()) {//장바구니가 비어있지 않을 때만 물음
                    System.out.println("\n1. 주문 확정 | 2. 메인으로 돌아가기");
                    System.out.println("입력: ");
                    int orderConfirm = sc.nextInt();
                    if (orderConfirm == 1) {
                        shoppingCart.order();

                    } else if (orderConfirm == 2) {
                        System.out.println("메인 메뉴로 돌아갑니다.");
                    }
                }
                }
            } else if (mainChoice == 2 || mainChoice  == 3) {
                System.out.println("준비 중인 카테고리입니다.");
            } else if (mainChoice == 4){ //장바구니 로직
                shoppingCart.displayCart();
                if(!shoppingCart.isEmpty()){
                    System.out.println("\n1. 주문 확정 | 2. 메인으로 돌아가기");
                    int orderConfirm = sc.nextInt();
                    if (orderConfirm == 1) shoppingCart.order();
                }
            } else if (mainChoice == 6) {
                runAdminMode();
            } else {
                System.out.println("잘못된 입력입니다.");
            }

        }
        }// start() 메서드 종료

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    // **관리자 인증 로직**
    private void runAdminMode(){
        int failCount = 0; // 비밀번호 틀린 횟수 저장할 변수
        while (failCount < 3){
            System.out.println("관리자 비밀번호를 입력하세요: ");
            String input = sc.next(); // 사용자에게 비번 입력받기

            
            if (administrator.authenticate(input)){
                System.out.println("인증 성공! 관리자 메뉴로 진입합니다...");
                showAdminMenu(); // 인증 성공시 관리자 메뉴로
                return; // 메서드 종료
            } else{
                failCount ++; // 틀렸으니 횟수 1 증가
                System.out.println("비밀번호가 틀렸습니다.(" + failCount + "/3");
            }
        }
        System.out.println("3회 실패하여 메인으로 돌아갑니다.");
    }

    private void showAdminMenu() {
        while(true) {
            System.out.println("\n[ 관리자 모드 ]");
            System.out.println("1. 상품 추가 ");
            System.out.println("2. 상품 수정 ");
            System.out.println("3. 상품 삭제 ");
            System.out.println("4. 전체 상품 상황 ");
            System.out.println("0. 메인으로 돌아가기 ");

            int adminChoice = sc.nextInt();

            if (adminChoice == 1) {
                addProductMode(currentCategory);
            } else if (adminChoice == 0) {
                System.out.println("관리자 모드를 종료하고 메인으로 돌아갑니다.");
                break; // while문 탈출 -> 메인으로
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
    
    // **상품 추가 로직**
    private void addProductMode(Category category) { // 어떤 카테고리에 추가할지 정보받음
        System.out.println("\n[ " + category.getCategoryName() + " 상품 추가 모드 ]");
        System.out.println("상품명을 입력해주세요: ");
        String name = sc.next();
        // * 중복검사 *
        if (administrator.isDuplicate(Category, name)) {
            System.out.println("이미 존재하는 상품명입니다. 등록을 취소합니다");
            return; // 중복이면 여기서 중단함
        }
        System.out.println("어느 카테고리에 상품을 추가 하시겠습니까?");
        System.out.println("가격을 입력해주세요: ");
        int price = sc.nextInt();
        System.out.println("상품 설명을 입력해주세요: ");
        String desc = sc.next();
        System.out.println("재고 수량을 입력해주세요: ");
        int stock = sc.nextInt();

        // 모든 정보 입력하면 새로운 상품 객체 생성
        Product product = new Product(name, price, desc, stock);

        // 카테고리 리스트에 등록
        category.addProduct(product);
        System.out.println("신규 상품이 성공적으로 등록되었습니다.");
    }
}

