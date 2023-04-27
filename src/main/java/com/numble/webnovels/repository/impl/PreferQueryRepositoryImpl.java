package com.numble.webnovels.repository.impl;

import com.numble.webnovels.domain.Customer;
import com.numble.webnovels.domain.Prefer;
import com.numble.webnovels.domain.QPrefer;
import com.numble.webnovels.domain.key.CustomerNovelId;
import com.numble.webnovels.repository.PreferQueryRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PreferQueryRepositoryImpl
        extends QuerydslRepositorySupport
        implements PreferQueryRepository {

    private static final QPrefer prefer = QPrefer.prefer;

    public PreferQueryRepositoryImpl() {
        super(Prefer.class);
    }

    /**
     * 소설의 사용자 선호도 여부 조회
     *
     * @param customerNovelId (사용자 ID, 소설 ID) 복합키
     * @return 소설 선호도 엔티티 객체
     */
    @Override
    public Optional<Prefer> findByCustomerAndNovel(CustomerNovelId customerNovelId) {
        return Optional.ofNullable(
                from(prefer)
                        .select(prefer)
                        .where(prefer.id().eq(customerNovelId))
                        .fetchOne());
    }

    /**
     * 소설의 사용자 선호작 조회
     *
     * @param customer 사용자 ID
     * @return 소설의 선호작 목록
     */
    @Override
    public Optional<List<Prefer>> findByCustomer(Customer customer) {
        return Optional.ofNullable(
                from(prefer)
                        .select(prefer)
                        .where(prefer.customer().id.eq(customer.getId()))
                        .fetch());
    }
}
