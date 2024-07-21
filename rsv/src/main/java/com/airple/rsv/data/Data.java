package com.airple.rsv.data;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @Column(columnDefinition = "TEXT")
    private String R_manageid;

    private LocalDateTime R_sensetime;

    private String levelStr300;
    private String levelStr600;
    private String airHeightStr300;
    private String airHeightStr600;
    private String temperature;
    private String voltage;
    private String velocityStr600;
    private String instaneousFlowStr600;
    private String fault;
}
