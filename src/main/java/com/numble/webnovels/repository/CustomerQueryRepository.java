package com.numble.webnovels.repository;

import com.numble.webnovels.domain.Customer;

import java.util.Optional;

/**
 * 사용자 QueryDSL 레포지토리 인터페이스 (조회 용도)
 */
public interface CustomerQueryRepository {
    // TODO. 사용자의 유일성을 나타낼 만한 컬럼 또는 값을 정의 후 조회 인터페이스에 추가
    Optional<Customer> findById(Long id);
}
