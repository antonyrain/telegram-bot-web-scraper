package com.antonyrain.backserver.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.antonyrain.backserver.model.Filter;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Long> {
  @Query(value = "select * from filters where filters.telegram_user_id = :id", nativeQuery = true)
  List<Filter> findAllById(@Param("id") Long id);

  @Modifying
  @Transactional
  @Query(value = "delete from filters where filters.telegram_user_id = :id", nativeQuery = true)
  public void deleteAllFilters(@Param("id") Long id);
}