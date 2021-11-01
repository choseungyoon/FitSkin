package com.fitksin.server.product.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "ingredientCode")
    private String ingredientCode;

    @Column(name = "subIngredient")
    private String subIngredient;

    @Column(name = "formulation")
    private String formulation;

    @Column(name = "registeredDate")
    private Date registeredDate;

    @Column(name = "origin")
    private String origin;

    @Column(name = "perContent")
    private double perContent;

    @Column(name = "price")
    private int price;

    @Column(name = "totalVolume")
    private int totalVolume;

    @Column(name = "dayVolume")
    private int dayVolume;

    @Column(name = "image" ,columnDefinition = "LONGTEXT")
    private String image;

    @Column(name = "etcIngredient")
    private String etcIngredient;

    @Column(name = "description")
    private String description;

}
