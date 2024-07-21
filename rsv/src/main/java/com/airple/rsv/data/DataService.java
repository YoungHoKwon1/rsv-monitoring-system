package com.airple.rsv.data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DataService {

    private final DataRepository dataRepository;

    private Specification<Question> search(String kw) {
        // return new Specification<>() {
        // private static final long serialVersionUID = 1L;

        // @Override
        // public Predicate toPredicate(Root<Question> q, CriteriaQuery<?> query,
        // CriteriaBuilder cb) {
        // query.distinct(true); // 중복을 제거
        // Join<Data, Id> u1 = q.join("author", JoinType.LEFT);
        // Join<Data, Answer> a = q.join("answerList", JoinType.LEFT);
        // Join<Data, SiteUser> u2 = a.join("author", JoinType.LEFT);

        // return cb.or(cb.like(q.get("subject"), "%" + kw + "%"), // 제목
        // cb.like(q.get("content"), "%" + kw + "%"), // 내용
        // cb.like(u1.get("username"), "%" + kw + "%"), // 질문 작성자
        // cb.like(a.get("content"), "%" + kw + "%"), // 답변 내용
        // cb.like(u2.get("username"), "%" + kw + "%")); // 답변 작성자
        // }
        // };
        return new Specification<>() {

        };
    }

    public List<Data> getList() {
        return this.dataRepository.findAll();
    }

    public Page<Data> getList(int page, String kw) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        Specification<Question> spec = search(kw);
        return this.dataRepository.findAll(spec, pageable);
    }
}
