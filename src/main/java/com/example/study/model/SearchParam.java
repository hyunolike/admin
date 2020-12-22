package com.example.study.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// lombok은 자바 생산성을 향상 시킴
@Data
@AllArgsConstructor //모든 매개변수를 가지는 생성자 생성
@NoArgsConstructor  // << 기본 생성자 추가
public class SearchParam {

    private String account;
    private String email;
    private int page;

    // {"account":"", "email":"","page":0} json형태 데이터통신

}
