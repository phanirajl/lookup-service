package com.suhas.service.lookup.repository;

import com.suhas.service.lookup.model.Country;
import org.springframework.data.cassandra.repository.TypedIdCassandraRepository;

public interface CountryRepository extends TypedIdCassandraRepository<Country, Long> {
}
