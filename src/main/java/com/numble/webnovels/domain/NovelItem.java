package com.numble.webnovels.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(notes = "소설(편당) 키 값", example = "1", required = true)
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty(notes = "소설(편당) 전체 페이지", example = "168", required = true)
    private int allPages;

    @Column(nullable = false)
    @ApiModelProperty(notes = "소설(편당) 무료 여부", example = "true", required = true)
    private Boolean isFree;

    @Column(nullable = false)
    @ApiModelProperty(notes = "소설(편당) 파일 크기", example = "2048", required = true)
    private int fileSize;

    @Column(nullable = false)
    @ApiModelProperty(notes = "소설(편당) 파일 경로", example = "src/main/resources/sample/novel1-1", required = true)
    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "novel_id")
    @ToString.Exclude
    @JsonIgnore
    private Novel novel;
}
