package com.numble.webnovels.dto;

import com.numble.webnovels.domain.Novel;
import com.numble.webnovels.domain.NovelItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class NovelResponseDto {
    @ApiModelProperty(value = "소설 키 값", example = "1", required = true)
    private Long id;
    @ApiModelProperty(value = "소설 제목", example = "Numble Novels", required = true)
    private String title;
    @ApiModelProperty(value = "소설 한줄 소개", example = "Numble에서 제작한 웹 소설", required = true)
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