package com.fitksin.server.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Nullable
    @Column(name = "description")
    private String description;

    @Nullable
    @Column(name = "icon")
    private String icon;

    @Nullable
    @Column(name="moisturizing")
    private int moisturizing;

    @Nullable
    @Column(name="sebum")
    private int sebum;

    @Nullable
    @Column(name="sensitivity")
    private int sensitivity;

    @Nullable
    @Column(name="elasticity")
    private int elasticity;

    @Nullable
    @Column(name="pigmentation")
    private int pigmentation;

    @Nullable
    @Column(name="trouble")
    private int trouble;

}
