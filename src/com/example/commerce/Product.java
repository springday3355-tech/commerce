package com.example.commerce;

public class Product {
    public int getName;
    // 속성

    // 1.캡슐화
       private String name;
       private int price;
       private String description;
       private int stock;


       // 생성자
    public Product(String name, int price, String description, int stock){
        this.name=name;
        this.price=price;
        this.description=description;
        this.stock=stock;

    }
    // 2. 외부에서 데이터 가져가기 위해 getter메서드 추가

    public String getName() {return name;}

    public int getPrice() {return price;}

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }





    }

