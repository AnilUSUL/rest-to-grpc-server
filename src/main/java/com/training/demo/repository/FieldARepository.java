package com.training.demo.repository;

import com.training.demo.entity.FieldAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldARepository extends JpaRepository<FieldAEntity, Long> {

}
