package com.example.commerce;

public class Product {
    public String getName;
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

    public void reduceStock(int quantity){
        if(this.stock < quantity){
            System.out.println("에러: 재고가 부족합니다! (현재 재고: " + this.stock + ")" );
            return;// 재고 없으면 여기서 메서드 종료함
        }
        // 재고 충분하면 현재 내 재고에서 수량 뺌
        this.stock = this.stock - quantity;


    }





    }

