package com.example.commerce;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    // 속성
    List<Product> products;

    // 생성자
    public CommerceSystem(List<Product> products){
        this.products = products;
    }


    // 기능
    public void start(){
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###");


        while(true){
            System.out.println("[실시간 커머스 플랫폼 - 전자제품]");
            int index = 1;
            for (Product product : products) { //목록 출력
                System.out.println(index + "." + product.name + " | "+
                        df.format(product.price)+ " 원 | " + product.description );
                index++;
            }

            System.out.println("0. 종료 | 프로그램 종료");

            System.out.println("입력: ");
            int choice = sc.nextInt();// 번호 입력받기

            if(choice == 0){
                System.out.println("커머스 플랫폼을 종료합니다ㅣ.");
                break; // 0이면 종료됨
            }
            // choice가 0이 아닐 때 실행될 부분
            if (choice > 0 && choice <= products.size()){
                Product selectedProduct = products.get(choice -1); // 사용자가 1입력하면 products.get(0)을 가져온다

                System.out.println("\n[상품 상세 정보]");
                System.out.println("명칭: " + selectedProduct.name); // 1~4 상세정보 출력
                System.out.println("가격: " + df.format(selectedProduct.price) + "원");
                System.out.println("설명: " + selectedProduct.description);
                System.out.println("재고: " + selectedProduct.stock + "개");
                System.out.println("--------------------------");

            } else if (choice != 0) { // 0~4 외 숫자들 에러메세지출력
                System.out.println("해당하는 상품 번호가 없습니다. 다시 입력해주세요.");


            }
        }

    }


}
