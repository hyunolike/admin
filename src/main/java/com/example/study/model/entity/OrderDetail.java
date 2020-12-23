package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //order_detail 자동적으로 연결

@ToString(exclude = {"user","item"}) // 스택오버 방지
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderAt;

//    orderDetail 입장에서 생각!!!
    // N : 1
    @ManyToOne
    private User user; //user_id

    // N : 1
    @ManyToOne
    private Item item;
}
