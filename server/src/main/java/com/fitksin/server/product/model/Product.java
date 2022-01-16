package com.fitksin.server.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    private String id;

    @Nullable
    @Column(name = "name")
    private String name;

    @Nullable
    @Column(name = "main_code")
    private String mainCode;

    @Nullable
    @Column(name = "formulation")
    private String formulation;

    @Nullable
    @Column(name = "certification_date")
    private Date certificationDate;

    @Nullable
    @Column(name = "origin")
    private String origin;

    @Nullable
    @Column(name = "per_content")
    private Double perContent;

    @Nullable
    @Column(name ="unit")
    private String unit;

    @Nullable
    @Column(name = "price")
    private Integer price;

    @Nullable
    @Column(name = "total_volume")
    private Integer totalVolume;

    @Nullable
    @Column(name = "day_volume")
    private Integer dayVolume;

    @Nullable
    @Column(name = "etc")
    private String etc;

    @Nullable
    @Column(name = "image" ,columnDefinition = "LONGTEXT")
    private String image;

}
