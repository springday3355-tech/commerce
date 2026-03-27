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
            for (Product product : products) {
                System.out.println(index + "." + product.name + " | "+ df.format(product.price)+ " 원 | " + product.description );
                index++;
            }

            System.out.println("0. 종료 | 프로그램 종료");

            System.out.println("입력: ");
            int choice = sc.nextInt();

            if(choice == 0){
                System.out.println("커머스 플랫폼을 종료합니다ㅣ.");
                break;
            }
        }

    }


}
