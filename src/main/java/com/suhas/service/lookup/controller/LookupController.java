package com.suhas.service.lookup.controller;

import com.suhas.service.lookup.dto.CountryDTO;
import com.suhas.service.lookup.model.Country;
import com.suhas.service.lookup.service.LookupService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

	@ApiOperation(value = "Save Document", notes = "API to save a Document", nickname = "saveDocument")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Success",
					response = List.class, responseContainer = "List") })
	@PostMapping("/countries")
	public ResponseEntity<CountryDTO> createCountry(@Valid @RequestBody Country countryDetails) {
		lookupService.createCountry(countryDetails);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@ApiOperation(value = "Delete Document By Id", notes = "API to delete a Document", nickname = "deleteDocument")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Document not found"),
			@ApiResponse(code = 200, message = "Success",
					response = List.class, responseContainer = "List") })
	@DeleteMapping("/countries/{id}")
	public ResponseEntity<?> deleteCountry(@ApiParam(value = "countryId", required = true) @PathVariable(value = "id") Long countryId) {
		lookupService.deleteCountry(countryId);
		return ResponseEntity.ok().build();
	}

}
