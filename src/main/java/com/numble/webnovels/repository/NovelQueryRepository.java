package com.numble.webnovels.repository;

import com.numble.webnovels.domain.Novel;

import java.util.List;
import java.util.Optional;

/**
 * 소설 QueryDSL 레포지토리 인터페이스 (조회 용도)
 */
public interface NovelQueryRepository {
    Optional<Novel> findById(Long id);
    Optional<Novel> findTopByClickCount();
    Optional<List<Novel>> findAllByClickCount();
}
