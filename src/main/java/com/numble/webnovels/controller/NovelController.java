package com.numble.webnovels.controller;

import com.numble.webnovels.dto.NovelDetailResponseDto;
import com.numble.webnovels.dto.NovelItemResponseDto;
import com.numble.webnovels.dto.NovelResponseDto;
import com.numble.webnovels.service.NovelService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping("/api")
@Path("/api")
@Api(value = "NovelController", description = "소설 작품 및 편당 조회/수정/삭제 API")
public class NovelController {

    private final NovelService novelService;

    @Autowired
    public NovelController(NovelService novelService) {
        this.novelService = novelService;
    }

    @GetMapping("/search/best")
    @GET
    @Path(value = "/search/best")
    @ApiOperation(
            value="",
            notes="베스트 소설 작품을 조회한다.",
            response = NovelResponseDto.class,
            responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<List<NovelResponseDto>> getAllBestNovels() {
        List<NovelResponseDto> novelResponseDtoList = novelService.getAllBestNovels();

        // TODO. 첫 번째 소설(편당) 조회를 통해 파일 경로를 찾고 이미지 불러오기

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(novelResponseDtoList);
    }

    @GetMapping("/search/topic")
    @GET
    @Path(value = "/search/topic")
    @ApiOperation(
            value="",
            notes="신작 베스트 소설 작품을 조회한다.",
            response = NovelResponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<NovelResponseDto> getNewBestNovel() {
        NovelResponseDto novelResponseDto = novelService.getNewBestNovel();

        // TODO. 첫 번째 소설(편당) 조회를 통해 파일 경로를 찾고 이미지 불러오기

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(novelResponseDto);
    }

    @GetMapping("/search/novel")
    @GET
    @Path(value = "/search/novel")
    @ApiOperation(
            value="",
            notes="소설 작품을 조회한다.",
            response = NovelDetailResponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<NovelDetailResponseDto> getNovelById(
            @ApiParam(name = "소설 고유의 ID 값", value = "Novel Id", example = "1", required = true) @RequestParam(name = "novelId") Long novelId) {
        NovelDetailResponseDto novelResponseDto = novelService.getNovel(novelId);

        // TODO. 첫 번째 소설(편당) 조회를 통해 파일 경로를 찾고 이미지 불러오기

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(novelResponseDto);
    }

    @GetMapping("/search/novelItem")
    @GET
    @Path(value = "/search/novelItem")
    @ApiOperation(
            value="",
            notes="소설 작품(편당)을 조회한다.",
            response = NovelDetailResponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<NovelItemResponseDto> getNovelItemById(
            @ApiParam(name = "소설 고유의 ID 값", value = "Novel Id", example = "1", required = true) @RequestParam(name = "novelId") Long novelId,
            @ApiParam(name = "소설(편당) 고유의 ID 값", value = "Novel Item Id", example = "1", required = true) @RequestParam(name = "novelItemId") Long novelItemId) {
        NovelItemResponseDto novelItemResponseDto = novelService.getNovelItem(novelId, novelItemId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(novelItemResponseDto);
    }
}