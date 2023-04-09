package com.numble.webnovels.controller;

import com.numble.webnovels.dto.NovelDetailResponseDto;
import com.numble.webnovels.dto.NovelItemResponseDto;
import com.numble.webnovels.dto.NovelResponseDto;
import com.numble.webnovels.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/novel")
public class NovelController {

    private final NovelService novelService;

    @Autowired
    public NovelController(NovelService novelService) {
        this.novelService = novelService;
    }

    @GetMapping("/search/best")
    public ResponseEntity<List<NovelResponseDto>> getAllBestNovels() {
        List<NovelResponseDto> novelResponseDtoList = novelService.getAllBestNovels();

        // TODO. 첫 번째 소설(편당) 조회를 통해 파일 경로를 찾고 이미지 불러오기

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(novelResponseDtoList);
    }

    @GetMapping("/search/topic")
    public ResponseEntity<NovelResponseDto> getNewBestNovel() {
        NovelResponseDto novelResponseDto = novelService.getNewBestNovel();

        // TODO. 첫 번째 소설(편당) 조회를 통해 파일 경로를 찾고 이미지 불러오기

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(novelResponseDto);
    }

    @GetMapping("/search/{novelId}")
    public ResponseEntity<NovelDetailResponseDto> getNovelById(@PathVariable Long novelId) {
        NovelDetailResponseDto novelResponseDto = novelService.getNovel(novelId);

        // TODO. 첫 번째 소설(편당) 조회를 통해 파일 경로를 찾고 이미지 불러오기

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(novelResponseDto);
    }

    @GetMapping("/search/{novelId}/{novelItemId}")
    public ResponseEntity<NovelItemResponseDto> getNovelItemById(@PathVariable Long novelId,
                                                                 @PathVariable Long novelItemId) {
        NovelItemResponseDto novelItemResponseDto = novelService.getNovelItem(novelId, novelItemId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(novelItemResponseDto);
    }
}