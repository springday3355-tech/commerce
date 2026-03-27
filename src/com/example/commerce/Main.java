package com.example.commerce;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        Product p1 = new Product("Galaxy S26" , 1200000 , "최신 안드로이드 스마트폰", 24);
        Product p2 = new Product("iPhone 17", 1350000, "Apple의 최신 스마트폰", 17);
        Product p3 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 8);
        Product p4 = new Product("AirPods Pro 3", 350000, "노이즈 캔슬링 무선 이어폰", 35);


        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

        // 커머스시스템 객체 소환
        CommerceSystem system= new CommerceSystem(products);

        // 커머스 시스템 노동 시작
        system.start();


        }
        

    }