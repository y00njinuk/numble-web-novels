package com.numble.webnovels.dto;

import com.numble.webnovels.domain.Novel;
import com.numble.webnovels.domain.NovelItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class NovelDetailResponseDto {
    @ApiModelProperty(value = "소설 키 값", example = "1", required = true)
    private Long id;
    @ApiModelProperty(value = "소설 제목", example = "Numble Novels", required = true)
    private String title;
    @ApiModelProperty(value = "소설 한줄 소개", example = "Numble에서 제작한 웹 소설", required = true)
    private String comment;
    @ApiModelProperty(value = "소설 클릭 수", example = "102", required = true)
    private int clickCount;
    @ApiModelProperty(value = "소설에 해당하는 소설(편당) 목록",
            example = "'['{'id': '1','allPages': '168', 'isFree': 'true', 'fileSize': '2048', 'filePath': 'src/main/resources/sample/novel1-1'}']")
    private List<NovelItem> novelItemList;

    /**
     * 응답 객체 생성 메서드
     *
     * @param novel 소설 엔티티 객체
     */
    public NovelDetailResponseDto(Novel novel) {
        this.id = novel.getId();
        this.title = novel.getTitle();
        this.comment = novel.getComment();
        this.clickCount = novel.getClickCount();
        this.novelItemList = novel.getNovelItemList();
    }
}