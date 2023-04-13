package com.numble.webnovels.repository;

import com.numble.webnovels.domain.ReadPage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 소설(편당) 읽은 페이지 레포지토리 인터페이스 (저장 및 수정 용도)
 */
public interface ReadPageRepository extends JpaRepository<ReadPage, Long> {
}
