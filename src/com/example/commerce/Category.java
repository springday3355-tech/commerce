package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

public class Category {

    // 속성
    //전자제품 카테고리
    private String categoryName;
    //List<Product>를 카테고리 클래스가 관리함
    private  List<Product> products;

    // 생성자
    public Category(String categoryName){
        this.categoryName = categoryName;
        this.products = new ArrayList<>(); // 생성시점에 리스트 초기화
    }

    // 기능: 상품목록 추가
    public void addProduct(Product product){
        this.products.add(product);
    }

    // 요구사항: 카테고리 이름 반환
    public String getCategoryName() {
        return categoryName;
    }

    // 기능: 상품목록 반환
    public List<Product> getProducts() {
        return products;
    }
}
