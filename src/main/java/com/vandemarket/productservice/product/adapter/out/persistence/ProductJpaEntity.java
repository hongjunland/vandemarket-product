package com.vandemarket.productservice.product.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="products")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductJpaEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private int price;
}
