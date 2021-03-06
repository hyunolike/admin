package com.example.study.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //order_detail 자동적으로 연결
//@ToString(exclude = {"user","item"}) // 스택오버 방지
@ToString(exclude = {"orderGroup","item"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

//    외래키
//    orderdetail N : 1 item
    @ManyToOne
    private Item item;

//    orderDetail N : 1 OrderGroup
    @ManyToOne
    private OrderGroup orderGroup;



////    orderDetail 입장에서 생각!!!
//    // N : 1
//    @ManyToOne
//    private User user; //user_id
//
//    // N : 1
//    @ManyToOne
//    private Item item;
}
