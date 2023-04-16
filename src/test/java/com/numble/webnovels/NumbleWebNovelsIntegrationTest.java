/**
 * Spring Boot Integration Test
 *
 * Reference
 * - spring.io/guides/gs/testing-web/#:~:text=Another%20useful%20approach,starting%20the%20server.
 * - www.baeldung.com/integration-testing-in-spring
 */

package com.numble.webnovels;

import com.numble.webnovels.domain.Novel;
import com.numble.webnovels.domain.NovelItem;
import com.numble.webnovels.repository.NovelItemRepository;
import com.numble.webnovels.repository.NovelRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class NumbleWebNovelsIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    NovelRepository novelRepository;

    @Autowired
    NovelItemRepository novelItemRepository;

    @BeforeEach
    void setUp() {
        // not implemented.
    }

    @AfterEach
    void tearDown() {
        novelItemRepository.deleteAll();
        novelRepository.deleteAll();
    }

    @Test
    @DisplayName("소설 ID 값을 통해 소설을 정상적으로 조회할 수 있다.")
    void givenNovelId_whenFindById_thenReturnNovel() throws Exception {
        Random rndGen = new Random();

        Novel newNovel = new Novel(1L, "Numble Novels", "Nuble Novels", 0,
                new ArrayList<>());

        List<NovelItem> novelItemList = IntStream.iterate(1, i -> i + 1)
                .limit(rndGen.nextInt(10) + 1)
                .mapToObj(n -> new NovelItem(
                        new Long(n),
                        rndGen.nextInt(100),
                        rndGen.nextBoolean(),
                        rndGen.nextInt(1024),
                        "src/main/resources/sample/novel1-" + n,
                        newNovel))
                .collect(Collectors.toList());

        newNovel.addNovelItem(novelItemList);
        novelRepository.saveAndFlush(newNovel);

        mockMvc.perform(get("/api/search/novel?novelId="+ newNovel.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").value(newNovel.getTitle()))
                .andExpect(jsonPath("$.comment").value(newNovel.getComment()))
                .andExpect(jsonPath("$.clickCount").value(newNovel.getClickCount()))
                .andExpect(jsonPath("$.novelItemList").isArray())
                // TODO. Json 배열에 있는 원소 비교 구문 추가
                .andExpect(jsonPath("$.novelItemList", hasSize(novelItemList.size())));

        NovelItem newNovelItem = novelItemList.get(0);

        mockMvc.perform(get("/api/search/novelItem?novelId="+ newNovel.getId() + "&novelItemId=" + newNovelItem.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.allPages").value(newNovelItem.getAllPages()))
                .andExpect(jsonPath("$.isFree").value(newNovelItem.getIsFree()))
                .andExpect(jsonPath("$.fileSize").value(newNovelItem.getFileSize()))
                .andExpect(jsonPath("$.filePath").value(newNovelItem.getFilePath()));
    }
}
