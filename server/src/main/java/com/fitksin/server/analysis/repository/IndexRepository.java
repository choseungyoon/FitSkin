package com.fitksin.server.analysis.repository;

import com.fitksin.server.analysis.model.SkinIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexRepository extends JpaRepository<SkinIndex,String> {
}
