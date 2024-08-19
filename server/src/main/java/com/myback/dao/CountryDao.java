package com.myback.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "countries")
public class CountryDao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int country_id;
    
    @Column(nullable = true)
    private String name;
    
    @Column(nullable = false)
    private int area;

    @Column(nullable = true)
    @CreatedDate
    private Date national_day;

    @Column(nullable = false)
    private String country_code2;

    @Column(nullable = false)
    private String country_code3;

    @Column(nullable = false)
    private int region_id;

    @OneToMany(mappedBy="country_id")
    private List<CountryStatsDao> statistics;
    
}
