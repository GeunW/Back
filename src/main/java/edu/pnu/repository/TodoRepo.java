package edu.pnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Todo;

public interface TodoRepo extends JpaRepository<Todo, Long>{
    // 2.crud 페이징 기능
}
