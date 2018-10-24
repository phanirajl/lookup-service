package com.suhas.service.lookup.controller;

import com.suhas.service.lookup.dto.CountryDTO;
import com.suhas.service.lookup.service.LookupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "/api",
		description = "Document controller for handling all Lookup related services")
@RestController
@RequestMapping(value = "/api")
public class LookupController {

	@Autowired
	private LookupService lookupService;

	@ApiOperation(value = "Get All Countries", notes = "API to retrieve all Countries", nickname = "getCountries")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Success",
					response = List.class, responseContainer = "List") })
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public ResponseEntity<List<CountryDTO>> getAllCountries() {
		List<CountryDTO> countryDTOs = lookupService.getAllCountries();
		return ResponseEntity.status(HttpStatus.OK).body(countryDTOs);
	}

}
