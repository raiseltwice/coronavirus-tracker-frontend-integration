package ct.frontend.integration.controller;

import ct.frontend.integration.web.client.CountryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CountriesDTO;
import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CountryDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = "application/json")
public class CountryController {

    private final CountryClient countryService;

    @GetMapping("/countries")
    public ResponseEntity<CountriesDTO> getCountries() {
        return new ResponseEntity<>(countryService.getCountries(), HttpStatus.OK);
    }

    @GetMapping("/countries/{countryName}")
    public ResponseEntity<CountryDTO> getCountry(@PathVariable String countryName) {
        return new ResponseEntity<>(countryService.getCountry(countryName), HttpStatus.OK);
    }
}
