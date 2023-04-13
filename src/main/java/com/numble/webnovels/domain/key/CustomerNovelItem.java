package com.numble.webnovels.domain.key;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CustomerNovelItem implements Serializable {
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "novelItem_id")
    private Long novelItemId;
}