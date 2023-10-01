package com.example.webproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.webproject.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
