package com.suhas.service.lookup.model;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;

@Table(value = "country")
public class Country implements Serializable {

    @PrimaryKeyColumn(name = "country_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Long countryID;

    @Column("country_code")
    private String countryCode;

    @Column("country_name_ar")
    private String countryNameAr;

    @Column("country_name_en")
    private String countryNameEn;
}
