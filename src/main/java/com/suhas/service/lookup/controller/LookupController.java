package com.suhas.service.lookup.controller;

import com.suhas.service.lookup.dto.CountryDTO;
import com.suhas.service.lookup.service.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class LookupController {

	@Autowired
	private LookupService lookupService;

	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public ResponseEntity<List<CountryDTO>> getAllCountries() {
		List<CountryDTO> countryDTOs = lookupService.getAllCountries();
		return ResponseEntity.status(HttpStatus.OK).body(countryDTOs);
	}

}
