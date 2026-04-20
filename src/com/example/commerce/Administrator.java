package com.example.commerce;

public class Administrator {

    // 속성
    private String adminPassword = "1234"; // 초기 비밀번호

    // 기능
    // 비밀번호 확인 메서드
    public boolean authenticate(String input){
        return adminPassword.equals(input);
    }
    // 중복 상품명 검증 메서드
    public boolean isDuplicate(Category category, String name) {
        for (Product p : category.getProducts()) {
            if (p.getName().equals(name)) {
                return true; // 중복 발견
            }
        }
        return false; // 중복 없음
    }
}
