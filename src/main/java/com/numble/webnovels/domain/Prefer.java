package com.numble.webnovels.domain;

import com.numble.webnovels.domain.key.CustomerNovelId;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name="tb_prefer")
public class Prefer {
    @EmbeddedId
    private CustomerNovelId id;

    @MapsId("customerId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    private Customer customer;

    @MapsId("novelId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "novel_id")
    @ToString.Exclude
    private Novel novel;

    @Column(name = "is_prefer")
    private Boolean isPrefer;
}