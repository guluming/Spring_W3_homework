package com.sparta.spring_w3_homework.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NoticeboardRepository extends JpaRepository<Noticeboard, Long> {
    List<Noticeboard> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime startDatetime, LocalDateTime endDatetime);
}