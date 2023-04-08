package com.numble.webnovels.repository;

import com.numble.webnovels.domain.Novel;
import com.numble.webnovels.domain.NovelItem;

import java.util.Optional;

/**
 * 소설(편당) JPA 레포지토리 인터페이스 (조회 용도)
 */
public interface NovelItemQueryRepository {
    public Optional<NovelItem> findByNovel(Novel novel);
}
