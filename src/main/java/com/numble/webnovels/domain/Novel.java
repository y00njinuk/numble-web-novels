package com.numble.webnovels.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor // TODO. DTO 정의 시 어노테이션 제거
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name="tb_novel")
public class Novel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private int clickCount = 0;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "novel_id")
    private List<NovelItem> novelItemList = new ArrayList<>();

    /**
     * 새로운 소설 정보를 업데이트한다.
     *
     * @param newNovel 신규 소설 엔티티
     * @return 수정된 소설 엔티티
     */
    public Novel update(Novel newNovel) {
        this.title = newNovel.getTitle();
        this.comment = newNovel.getComment();
        this.clickCount = newNovel.getClickCount();

        return this;
    }

    public void addNovelItem(List<NovelItem> newNovelItemList) {
        newNovelItemList
                .forEach(novelItem -> {
                    if (!novelItemList.contains(novelItem))
                        novelItemList.add(novelItem);
                });
    }
}
