package com.fitksin.server.repository;

import com.fitksin.server.domain.SurveyHeaders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyHeadersRepository extends JpaRepository<SurveyHeaders,Integer> {
}
