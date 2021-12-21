package com.fitksin.server.analysis.repository;

import com.fitksin.server.analysis.model.TypeScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeScoreRepository extends JpaRepository<TypeScore,String> {
}
