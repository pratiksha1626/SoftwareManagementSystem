package com.example.SoftwareManagement.SoftwareController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SoftwareManagement.SoftwareServive.SoftwareServiceImplementation;
import com.example.SoftwareManagement.Softwaremodel.Software;


/*
 * The SoftwareController class is a Spring RestController responsible for handling
 * HTTP requests related to software data. It provides endpoints for performing CRUD
 * (Create, Read, Update, Delete) operations on software items.
*/

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

	public class SoftwareController {

	    // Dependency on the SoftwareServiceImplementation for business logic
		@Autowired
		public SoftwareServiceImplementation softwareServImpl;

		
		@GetMapping("software/searchByDevName")
		
		public ResponseEntity<List<Software>> getAllSoftwaresByDevName(@RequestParam(required = false) String developerName) {
			try {
				System.out.println("hiiiiiiii"+developerName);
				List<Software> softwareList = softwareServImpl.getAllSoftwaresByDevName(developerName);
			
				if(softwareList.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(softwareList, HttpStatus.OK);  
				
			}catch(Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

			}
		}
		
		

		
		
		

		

	    // Constructor to inject the SoftwareServiceImplementation dependency
		public SoftwareController(SoftwareServiceImplementation softwareServImpl) {
			this.softwareServImpl = softwareServImpl;
		}

		
		
		
	    // To save a new software
		@PostMapping("/software")
		
		public ResponseEntity<Software> saveSoftware(@RequestBody Software name){
			System.out.println(name);
			try {
			return new ResponseEntity<Software>(softwareServImpl.saveSoftwares(name), HttpStatus.CREATED);
			}

			catch(Exception e)
			{
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			
		}
		
		
	    // To update the details of an existing software
		@PutMapping("/software/{softwareId}")
		public ResponseEntity<Software> updateSoftwareDetailsById(@PathVariable int softwareId,@RequestBody Software softwareDetails){
			Optional<Software> softwareData=softwareServImpl.getSoftwareById(softwareId);
			
			if(softwareData.isPresent())
			{
				softwareServImpl.updateSoftwareDetails(softwareData, softwareDetails);
				return new ResponseEntity<Software>(softwareServImpl.updateSoftwareDetails(softwareData, softwareDetails), HttpStatus.OK);

			}
			else
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}
		
		
	    // To retrieve a list of all software items
		@GetMapping("/software")
			public ResponseEntity<List<Software>> getAllSoftwares(@RequestParam(required = false) String name) {
			try {
				List<Software> softwareList = softwareServImpl.getAllSoftwares(name);
			
				if(softwareList.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(softwareList, HttpStatus.OK);  
				
			}catch(Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

			}
		}
		
		
		
		
		
		
	    // To retrieve a specific software item by its ID
		@GetMapping("/software/getSoftware/{id}")
		public ResponseEntity<Software>  getSoftwareById(@PathVariable("id")  int softwareId){
			System.out.println(softwareId);
			
			Optional<Software> software = softwareServImpl.getSoftwareById(softwareId);
			
			if(software.isPresent())
			{
				return new ResponseEntity<>(software.get(),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		
		
		

	    // To delete a specific software item by its ID
		@DeleteMapping("/software/{softwareId}")
		
		public ResponseEntity<String> deleteSoftwareById(@PathVariable("softwareId")  int softwareId){
			Optional<Software> softwareData=softwareServImpl.getSoftwareById(softwareId);

			try {
				if(softwareData.isPresent())
				{
					softwareServImpl.deleteSoftwareById(softwareId);
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
			catch(Exception e)
			{
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
	}
	
		
		

		//deleteAll Data
		@DeleteMapping("/software")
		public ResponseEntity<HttpStatus> deleteAllSoftwares(){
			try
			{
				softwareServImpl.deleteAllSoftwares();
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			catch(Exception exception) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		//Search any Data
		@GetMapping("/software/{name}")
		public ResponseEntity<List<Software>> getAllSoftware(@PathVariable("name") String softwareName){
			
			try {
			
				if(softwareName != null) {
					
					return new ResponseEntity<>(softwareServImpl.getBySoftwareDetailsBySoftwareName(softwareName), HttpStatus.OK);
				}
		}
			catch(Exception excep) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return null;
		}
		
		
		@GetMapping("/software/isDesktopSoftware")
		public ResponseEntity<List<Software>> findByDesktopApplication() {
			try {
				List<Software> software = softwareServImpl.findByIsDesktopApplication(true);

				if (software.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(software, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping("/software/isWebApplicationSoftware")
		public ResponseEntity<List<Software>> findByWebApplication() {
			try {

				List<Software> restaurant = softwareServImpl.findByIsDesktopApplication(false);

				if (restaurant.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(restaurant, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		
		@GetMapping("software/filter/Rating/{direction}")
		public ResponseEntity<List<Software>> getAllSoftwareByRatingseHighToLow(@PathVariable("direction") String direction, @RequestParam(required = true) String rating){

			try {
				List<Software> softwareList = softwareServImpl.getAllSoftwareByRatingsHighToLow(direction, rating);
				if (softwareList.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}

				return new ResponseEntity<>(softwareList, HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
		
		
		@GetMapping("software/filter/Price/{direction}")
		public ResponseEntity<List<Software>> getAllSoftwareByPriceHighToLow(@PathVariable("direction") String direction, @RequestParam(required = true) String price){

			try {
				List<Software> softwareList = softwareServImpl.getAllSoftwareByPriceDesc(direction, price);
				System.out.println(direction);
				if (softwareList.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}

				return new ResponseEntity<>(softwareList, HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
	}