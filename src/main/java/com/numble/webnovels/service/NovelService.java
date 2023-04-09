package com.numble.webnovels.service;

import com.numble.webnovels.dto.NovelDetailResponseDto;
import com.numble.webnovels.dto.NovelResponseDto;

import java.util.List;

public interface NovelService {
    NovelDetailResponseDto getNovel(Long number);
    NovelResponseDto getNewBestNovel();
    List<NovelResponseDto> getAllBestNovels();
}