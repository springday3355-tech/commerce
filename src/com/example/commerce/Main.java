package com.example.commerce;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        System.out.println("[실시간 커머스 플랫폼 - 전자제품]");

        Product p1 = new Product("Galaxy S26" , 1200000 , "최신 안드로이드 스마트폰", 24);
        Product p2 = new Product("iPhone 17", 1350000, "Apple의 최신 스마트폰", 17);
        Product p3 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 8);
        Product p4 = new Product("AirPods Pro 3", 350000, "노이즈 캔슬링 무선 이어폰", 35);


        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

        DecimalFormat df = new DecimalFormat("#,###");

        int index = 1;
        for (Product product : products) {
            System.out.println(index + "." + product.name + " | "+ df.format(product.price)+ " 원 | " + product.description );
            index++;
        }

        System.out.println("0. 종료 | 프로그램 종료");

        Scanner sc = new Scanner(System.in);
        System.out.println("입력: ");
        int choice = sc.nextInt();

        if(choice == 0){
            System.out.println("커머스 플랫폼을 종료합니다ㅣ.");
        } else {
            System.out.println(choice + "번 상품을 선택하셨습니다.");
        }


        }
        

    }