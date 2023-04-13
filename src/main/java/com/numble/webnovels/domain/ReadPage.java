package com.numble.webnovels.domain;

import com.numble.webnovels.domain.key.CustomerNovelItem;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name="tb_read_page")
public class ReadPage {
    @EmbeddedId
    private CustomerNovelItem id;

    @MapsId("customerId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    private Customer customer;

    @MapsId("novelItemId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "novelItem_id")
    @ToString.Exclude
    private NovelItem novelItem;

    @Column(name = "read_pages")
    private int readPages;
}