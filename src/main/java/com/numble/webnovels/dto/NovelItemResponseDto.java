package com.numble.webnovels.dto;

import com.numble.webnovels.domain.NovelItem;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NovelItemResponseDto {
    private Long id;
    private int allPages;
    private Boolean isFree;
    private int fileSize;
    private String filePath;

    public NovelItemResponseDto(NovelItem novelItem) {
        this.id = novelItem.getId();
        this.allPages = novelItem.getAllPages();
        this.isFree = novelItem.getIsFree();
        this.fileSize = novelItem.getFileSize();
        this.filePath = novelItem.getFilePath();
    }
}
