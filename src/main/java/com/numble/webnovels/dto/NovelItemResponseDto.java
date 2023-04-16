package com.numble.webnovels.dto;

import com.numble.webnovels.domain.NovelItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NovelItemResponseDto {
    @ApiModelProperty(value = "소설(편당) 키 값", example = "1", required = true)
    private Long id;
    @ApiModelProperty(value = "소설(편당) 전체 페이지", example = "168", required = true)
    private int allPages;
    @ApiModelProperty(value = "소설(편당) 무료 여부", example = "true", required = true)
    private Boolean isFree;
    @ApiModelProperty(value = "소설(편당) 파일 크기", example = "2048", required = true)
    private int fileSize;
    @ApiModelProperty(value = "소설(편당) 파일 경로", example = "src/main/resources/sample/novel1-1", required = true)
    private String filePath;

    public NovelItemResponseDto(NovelItem novelItem) {
        this.id = novelItem.getId();
        this.allPages = novelItem.getAllPages();
        this.isFree = novelItem.getIsFree();
        this.fileSize = novelItem.getFileSize();
        this.filePath = novelItem.getFilePath();
    }
}
