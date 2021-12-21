package com.fitksin.server.survey.repository;

import com.fitksin.server.survey.domain.IndexDto;
import com.fitksin.server.survey.domain.SurveyResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ResultRepository extends JpaRepository<SurveyResult, UUID> {

    List<SurveyResult> findByEmailOrderByCreatedAtAsc(String email);

    @Query("SELECT new com.fitksin.server.survey.domain.IndexDto ( \n" +
            "CAST(AVG(moisturizing) AS int) as moisturizing,\n" +
            "CAST(AVG(sebum) AS int) as sebum, \n" +
            "CAST(AVG(sensitivity) AS int) as sensitivity,\n" +
            "CAST(AVG(elasticity) AS int) as elasticity, \n" +
            "CAST(AVG(pigmentation) AS int) as pigmentation,\n" +
            "CAST(AVG(trouble) AS int) as trouble)\n" +
            "FROM SurveyResult where sex = :sex")
    IndexDto selectAverageScoreBySex(@Param("sex") boolean sex);

    @Query("SELECT new com.fitksin.server.survey.domain.IndexDto ( \n" +
            "CAST(AVG(moisturizing) AS int) as moisturizing,\n" +
            "CAST(AVG(sebum) AS int) as sebum, \n" +
            "CAST(AVG(sensitivity) AS int) as sensitivity,\n" +
            "CAST(AVG(elasticity) AS int) as elasticity, \n" +
            "CAST(AVG(pigmentation) AS int) as pigmentation,\n" +
            "CAST(AVG(trouble) AS int) as trouble)\n" +
            "FROM SurveyResult where age between :from and :to")
    IndexDto selectAverageScoreByAge(@Param("from") int from, @Param("to") int to);


}
