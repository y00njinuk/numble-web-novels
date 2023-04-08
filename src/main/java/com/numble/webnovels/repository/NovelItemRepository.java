package com.numble.webnovels.repository;

import com.numble.webnovels.domain.NovelItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 소설(편당) JPA 레포지토리 인터페이스 (저장 및 수정 용도)
 */
public interface NovelItemRepository extends JpaRepository<NovelItem, Long> {
}
