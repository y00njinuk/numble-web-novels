package com.numble.webnovels.repository;

import com.numble.webnovels.domain.ReadPage;
import com.numble.webnovels.domain.key.CustomerNovelItem;

import java.util.Optional;

/**
 * 소설(편당) 읽은 페이지 QueryDSL 레포지토리 인터페이스 (조회 용도)
 */
public interface ReadPageQueryRepository {
    Optional<ReadPage> findByCustomerAndNovelItem(CustomerNovelItem customerNovelItem);
}
