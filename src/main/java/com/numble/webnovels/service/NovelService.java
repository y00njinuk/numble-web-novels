package com.numble.webnovels.service;

import com.numble.webnovels.dto.NovelDetailResponseDto;
import com.numble.webnovels.dto.NovelItemResponseDto;
import com.numble.webnovels.dto.NovelResponseDto;

import java.util.List;

public interface NovelService {
    NovelDetailResponseDto getNovel(Long number);
    NovelItemResponseDto getNovelItem(Long novelId, Long novelItemId);
    NovelResponseDto getNewBestNovel();
    List<NovelResponseDto> getAllBestNovels();
}