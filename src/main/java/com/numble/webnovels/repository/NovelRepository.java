package com.numble.webnovels.repository;

import com.numble.webnovels.domain.Novel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 소설 JPA 레포지토리 인터페이스 (저장 및 수정 용도)
 */
public interface NovelRepository extends JpaRepository<Novel, Long> { }
