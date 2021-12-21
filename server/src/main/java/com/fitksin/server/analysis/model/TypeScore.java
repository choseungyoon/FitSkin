package com.fitksin.server.analysis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "typeScore")
public class TypeScore {

    @Id
    private String type;

    @Column(name="moisturizing")
    private int moisturizing;

    @Column(name="sebum")
    private int sebum;

    @Column(name="sensitivity")
    private int sensitivity;

    @Column(name="elasticity")
    private int elasticity;

    @Column(name="pigmentation")
    private int pigmentation;

    @Column(name="trouble")
    private int trouble;
}
