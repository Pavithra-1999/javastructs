package com.akhm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhm.repository.entity.StudentEntity;

@Repository
public interface StudentEntityRepository extends JpaRepository<StudentEntity, Integer>{

}
