package com.suhas.service.lookup.service;

import com.suhas.service.lookup.dto.CountryDTO;
import com.suhas.service.lookup.model.Country;

import java.util.List;

public interface LookupService {

    List<CountryDTO> getAllCountries();

    void createCountry(Country countryDetails);

    void deleteCountry(Long countryId);
}
