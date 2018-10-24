package com.suhas.service.lookup.service.impl;

import com.suhas.service.lookup.dto.CountryDTO;
import com.suhas.service.lookup.model.Country;
import com.suhas.service.lookup.repository.CountryRepository;
import com.suhas.service.lookup.service.LookupService;
import com.suhas.service.lookup.utils.CommonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@CacheConfig(cacheNames = "countryCache")
public class LookupServiceImpl implements LookupService {

    @Autowired
    private CountryRepository countryRepository;

    /**
     * when method annotated with @Cacheable annotation,
     * it will be executed only once for the given cachekey, until the cache expires or gets cleared.
     * @return
     */
    @Override
    @Cacheable
    public List<CountryDTO> getAllCountries() {
        List<CountryDTO> countryDTOList = null;
        simulateSlowService();
        Iterable<Country> iterableCountry = countryRepository.findAll();
        if (CommonUtils.isNotNull(iterableCountry)) {
            countryDTOList = new ArrayList<>();
            Iterator<Country> countryIterator = iterableCountry.iterator();
            while (countryIterator.hasNext()) {
                Country country = countryIterator.next();
                CountryDTO countryDTO = new CountryDTO();
                BeanUtils.copyProperties(country, countryDTO);
                countryDTOList.add(countryDTO);
            }
            Collections.sort(countryDTOList, new Comparator<CountryDTO>() {
                @Override
                public int compare(CountryDTO o1, CountryDTO o2) {
                    return o1.getCountryNameEn().compareTo(o2.getCountryNameEn());
                }
            });
        }
        return countryDTOList;
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
