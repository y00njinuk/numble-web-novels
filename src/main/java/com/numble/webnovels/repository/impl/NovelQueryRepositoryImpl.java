package com.numble.webnovels.repository.impl;

import com.numble.webnovels.domain.Novel;
import com.numble.webnovels.domain.QNovel;
import com.numble.webnovels.repository.NovelQueryRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NovelQueryRepositoryImpl
        extends QuerydslRepositorySupport
        implements NovelQueryRepository {

    private static final QNovel novel = QNovel.novel;

    public NovelQueryRepositoryImpl() {
        super(Novel.class);
    }

    /**
     * 소설 조회 인터페이스
     *
     * @param id 소설 고유의 키 값
     * @return 소설 엔티티 객체
     */
    public Optional<Novel> findById(Long id) {
        return Optional.ofNullable(
                from(novel)
                        .select(novel)
                        .where(novel.id.eq(id))
                        .fetchOne());
    }

    /**
     * 상위 1개 소설 조회 인터페이스 (클릭수 기준)
     *
     * @return 소설 엔티티 객체
     */
    public Optional<Novel> findTopByClickCount() {
        // TODO. where 조건에 시간 범위 추가
        return Optional.ofNullable(
                from(novel)
                        .select(novel)
                        .orderBy(QNovel.novel.clickCount.desc())
                        .fetchOne());
    }

    /**
     * 전체 소설 목록 조회 인터페이스 (클릭수 기준)
     *
     * @return 소설 엔티티 타입의 리스트
     */
    public Optional<List<Novel>> findAllByClickCount() {
        // TODO. where 조건에 시간 범위 추가
        return Optional.ofNullable(
                from(novel)
                        .select(novel)
                        .orderBy(QNovel.novel.clickCount.desc())
                        .fetch());
    }
}