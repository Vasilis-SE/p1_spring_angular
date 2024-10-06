package com.myback.stats.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.myback.country.dao.CountryDao;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "country_stats")
public class StatsDao {
    
    @ManyToOne
    @JsonBackReference    
    @JoinColumn(name="country_id")
    private CountryDao country;

    @Id
    @Column(nullable = false)
    private int year;

    @Column(nullable = true)
    private long population;

    @Column(nullable = true)
    private long gdp;
    
}
