package com.airple.rsv.data;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Integer> {
    Data findBySubject(String subject);

    Data findBySubjectAndContent(String subject, String content);

    List<Data> findBySubjectLike(String subject);

    Page<Data> findAll(Pageable pageable);

    Page<Data> findAll(Specification<Question> spec, Pageable pageable);
}
