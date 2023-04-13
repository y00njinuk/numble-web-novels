package com.numble.webnovels.repository;

import com.numble.webnovels.domain.Prefer;
import com.numble.webnovels.domain.key.CustomerNovelId;

import java.util.Optional;

/**
 * 소설 선호도 QueryDSL 레포지토리 인터페이스 (조회 용도)
 */
public interface PreferQueryRepository {
    Optional<Prefer> findByCustomerAndNovel(CustomerNovelId customerNovelId);
}
