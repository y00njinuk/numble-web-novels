package com.numble.webnovels.dto;

import com.numble.webnovels.domain.Novel;
import com.numble.webnovels.domain.NovelItem;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class NovelResponseDto {
    private Long id;
    private String title;
    private String comment;

    /**
     * 응답 객체 생성 메서드
     *
     * @param novel 소설 엔티티 객체
     */
    public NovelResponseDto(Novel novel) {
        this.id = novel.getId();
        this.title = novel.getTitle();
        this.comment = novel.getComment();
    }
}