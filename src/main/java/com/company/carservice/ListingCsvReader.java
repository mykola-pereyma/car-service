package com.company.carservice;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class ListingCsvReader {

    public Iterable<Listing> readListingsFromCsv(String dealerId, InputStream inputStream) {
        List<Listing> listings = new ArrayList<>();
        try(
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                CSVReader csvReader = new CSVReader(reader)
        ){
            String[] line;
            boolean isDataLine = false;
            while ((line = csvReader.readNext()) != null) {
                if(!isDataLine){
                    isDataLine = true;
                } else {
                    Listing listing = new Listing();
                    listing.setDealerId(dealerId);
                    listing.setCode(line[0]);
                    String[] makeModel = line[1].split("/");
                    listing.setMake(makeModel[0]);
                    listing.setModel(makeModel[1]);
                    listing.setkW(Integer.parseInt(line[2]));
                    listing.setYear(Integer.parseInt(line[3]));
                    listing.setColor(line[4]);
                    listing.setPrice(Integer.parseInt(line[5]));
                    listings.add(listing);
                }
            }
        } catch (IOException ioex) {
            System.out.println("Failed to read CSV data.");
        }
        return listings;
    }

}
