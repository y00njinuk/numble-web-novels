package com.numble.webnovels.repository.impl;

import com.numble.webnovels.domain.Novel;
import com.numble.webnovels.domain.NovelItem;
import com.numble.webnovels.domain.QNovelItem;
import com.numble.webnovels.repository.NovelItemQueryRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Optional;

public class NovelItemQueryRepositoryImpl
        extends QuerydslRepositorySupport
        implements NovelItemQueryRepository {

    private static final QNovelItem novelItem = QNovelItem.novelItem;

    public NovelItemQueryRepositoryImpl() {
        super(NovelItem.class);
    }

    /**
     * 첫 소설(편당) 조회 인터페이스
     *
     * @param novel 소설 엔티티 객체
     * @return 소설(편당) 엔티티
     */
    @Override
    public Optional<NovelItem> findByNovel(Novel novel) {
        return Optional.ofNullable(
                from(novelItem)
                        .select(novelItem)
                        .where(novelItem.id.eq(novel.getId()))
                        .fetchOne());
    }
}
