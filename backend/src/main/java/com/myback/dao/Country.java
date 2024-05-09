package com.myback.dao;

import java.sql.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "countries")
public class Country {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id", nullable = false)
    private int cid;
    
    @Column(name = "name", nullable = true)
    private String name;
    
    @Column(name = "area", nullable = false)
    private int area;

    @Column(name = "national_day", nullable = true)
    @CreatedDate
    private Date nday;

    @Column(name = "country_code2", nullable = false)
    private String cc2;

    @Column(name = "country_code3", nullable = false)
    private String cc3;

    @Column(name = "region_id", nullable = false)
    private int rid;

}
