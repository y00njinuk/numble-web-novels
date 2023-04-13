package com.numble.webnovels.repository.impl;

import com.numble.webnovels.domain.Customer;
import com.numble.webnovels.domain.QCustomer;
import com.numble.webnovels.repository.CustomerQueryRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerQueryRepositoryImpl
        extends QuerydslRepositorySupport
        implements CustomerQueryRepository {

    private static final QCustomer customer = QCustomer.customer;

    public CustomerQueryRepositoryImpl() {
        super(Customer.class);
    }

    /**
     * 사용자 조회 인터페이스
     *
     * @param id 사용자 ID
     * @return 사용자 엔티티 객체
     */
    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(
                from(customer)
                        .select(customer)
                        .where(customer.id.eq(id))
                        .fetchOne());
    }
}
