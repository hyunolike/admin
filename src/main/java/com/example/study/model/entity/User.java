package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor // 기본생성자
//db table name과 동일하면 된다
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(name = "account")
    private String account;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

//    user 입장해서 생각!
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") //orderdetail에 있는 user 변수랑 동일해야 함
    private List<OrderDetail> orderDetailList;


}
