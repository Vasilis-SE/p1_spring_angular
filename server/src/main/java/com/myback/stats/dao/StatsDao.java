package com.myback.stats.dao;

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
    
    @Id
    @Column(nullable = false)
    private int country_id;

    @Id
    @Column(nullable = false)
    private int year;

    @Column(nullable = true)
    private long population;

    @Column(nullable = true)
    private long gdp;
    
}
