package com.numble.webnovels.service.impl;

import com.numble.webnovels.dto.NovelDetailResponseDto;
import com.numble.webnovels.dto.NovelResponseDto;
import com.numble.webnovels.repository.NovelQueryRepository;
import com.numble.webnovels.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class NovelServiceImpl implements NovelService {

    private final NovelQueryRepository novelQueryRepository;

    @Autowired
    public NovelServiceImpl(NovelQueryRepository novelQueryRepository) {
        this.novelQueryRepository = novelQueryRepository;
    }

    /**
     * 소설 단건 조회 서비스.
     *
     * @param number 소설 고유의 키 값
     * @return 소설 응답 객체
     */
    @Override
    public NovelDetailResponseDto getNovel(Long number) {
        return novelQueryRepository.findById(number)
                .map(NovelDetailResponseDto::new)
                .orElseThrow(RuntimeException::new);
    }

    /**
     * 신작 베스트 소설 조회 서비스.
     *
     * @return 소설 응답 객체
     */
    @Override
    public NovelResponseDto getNewBestNovel() {
        return novelQueryRepository.findTopByClickCount()
                .map(NovelResponseDto::new)
                .orElseThrow(RuntimeException::new);
    }

    /**
     * 화제의 베스트 셀러 조회 서비스.
     *
     * @return 소설 응답 객체 리스트
     */
    @Override
    public List<NovelResponseDto> getAllBestNovels() {
        return novelQueryRepository.findAllByClickCount()
                .orElseThrow(RuntimeException::new)
                .stream()
                .filter(Objects::nonNull)
                .map(NovelResponseDto::new)
                .collect(Collectors.toList());
    }
}