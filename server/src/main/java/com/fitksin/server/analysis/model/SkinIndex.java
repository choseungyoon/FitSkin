package com.fitksin.server.analysis.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "skinIndex")
public class SkinIndex {
    @Id
    private String skinIndex;

    private int score;

    @Column(name = "image" ,columnDefinition = "LONGTEXT")
    private String image;

    @Builder
    public SkinIndex(String index , int score){
        this.skinIndex = index;
        this.score = score;
    }
}



