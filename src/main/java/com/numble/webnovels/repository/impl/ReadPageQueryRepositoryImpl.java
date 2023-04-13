package com.numble.webnovels.repository.impl;

import com.numble.webnovels.domain.QReadPage;
import com.numble.webnovels.domain.ReadPage;
import com.numble.webnovels.domain.key.CustomerNovelItem;
import com.numble.webnovels.repository.ReadPageQueryRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReadPageQueryRepositoryImpl
        extends QuerydslRepositorySupport
        implements ReadPageQueryRepository {

    private static final QReadPage readPage = QReadPage.readPage;

    public ReadPageQueryRepositoryImpl() {
        super(ReadPage.class);
    }

    /**
     * 사용자의 소설(편당) 읽은 페이지 조회
     *
     * @param customerNovelItem (사용자 ID, 소설(편당) ID) 복합키
     * @return 소설(편당) 읽은 페이지 엔티티 객체
     */
    @Override
    public Optional<ReadPage> findByCustomerAndNovelItem(CustomerNovelItem customerNovelItem) {
        return Optional.ofNullable(
                from(readPage)
                        .select(readPage)
                        .where(readPage.id().eq(customerNovelItem))
                        .fetchOne());
    }
}
