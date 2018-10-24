package com.suhas.service.lookup.repository;

import com.suhas.service.lookup.model.Country;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface CountryRepository extends CassandraRepository<Country, Long> {
}
