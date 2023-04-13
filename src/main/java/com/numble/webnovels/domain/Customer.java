package com.numble.webnovels.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor // TODO. DTO 정의 시 어노테이션 제거
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name="tb_consumer")
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int numOfCoupon;
}