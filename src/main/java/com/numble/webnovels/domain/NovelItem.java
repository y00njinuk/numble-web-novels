package com.numble.webnovels.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor // TODO. DTO 정의 시 어노테이션 제거
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name="tb_novel_item")
public class NovelItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int allPages;

    @Column(nullable = false)
    private int currentPage;

    @Column(nullable = false)
    private Boolean isFree;

    @Column(nullable = false)
    private int fileSize;

    @Column(nullable = false)
    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "novel_id")
    @ToString.Exclude
    @JsonIgnore
    private Novel novel;
}
