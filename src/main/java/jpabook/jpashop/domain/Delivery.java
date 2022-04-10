package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order oder;

    @Embedded
    private Address address;

    @Enumerated(EnumType.ORDINAL)
    private DeliveryStatus status;
}
