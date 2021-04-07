package com.company.carservice;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ListingController {
    private final ListingRepository listingRepository;
    private final ListingCsvReader listingCsvReader;

    public ListingController(ListingRepository listingRepository, ListingCsvReader listingCsvReader) {
        this.listingRepository = listingRepository;
        this.listingCsvReader = listingCsvReader;
    }

    @GetMapping(path = "/search")
    public List<Listing> getListings(
            @RequestParam Optional<String> make,
            @RequestParam Optional<String> model,
            @RequestParam Optional<Integer> year,
            @RequestParam Optional<String> color) {
        return listingRepository.findAll(listingRepository.getListingQuery(make, model, year, color));
    }

    @PostMapping(path = "/upload_csv/{dealer_id}", consumes = "application/octet-stream")
    public ResponseEntity<?> uploadListingsCsv(
            @PathVariable(name = "dealer_id") String dealerId,
            @RequestBody Resource resource) {

        try {
            Iterable<Listing> listings = listingCsvReader.readListingsFromCsv(dealerId, resource.getInputStream());
            listingRepository.saveAll(listings);
        } catch (Exception e) {
            System.out.println("Failed to get csv InputStream.");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/vehicle_listings/{dealerId}", consumes = "application/json")
    public ResponseEntity<?> updateListings(
            @PathVariable(name = "dealerId") String dealerId,
            @RequestBody List<Listing> listings) {
        listings.forEach(listing -> listing.setDealerId(dealerId));
        listingRepository.saveAll(listings);
        return ResponseEntity.ok().build();
    }
}
