package com.antonyrain.backserver.repository;

import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.antonyrain.backserver.model.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    @Query(value = "select * from results where results.telegram_user_id = :id", nativeQuery = true)
    List<Result> findAllByUserId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from results where results.telegram_user_id = :id", nativeQuery = true)
    void deleteAllResults(@Param("id") Long id);

    @Query(value = "select * from results where results.telegram_user_id = :id and results.url = :url", nativeQuery = true)
    List<Result> findByIDandURL(@Param("id") Long id, @Param("url") String url);
}
