package ct.frontend.integration.controller;

import ct.frontend.integration.service.CountryCasesPerDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CasesPerDate;
import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CasesPerDateCollection;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = "application/json")
public class CountryCasesPerDateController {

    private final CountryCasesPerDateService countryCasesPerDateService;

    @GetMapping("/countries/{countryName}/cases-per-date")
    public ResponseEntity<CasesPerDateCollection> getCountryCasesPerDateCollection(@PathVariable String countryName) {
        return new ResponseEntity<>(
                countryCasesPerDateService.getCountryCasesPerDateCollection(countryName),
                HttpStatus.OK);
    }

    @GetMapping("/countries/{countryName}/cases-per-date/{date}")
    public ResponseEntity<CasesPerDate> getCountryCasesPerDateByDate(@PathVariable String countryName,
                                                                     @PathVariable String date) {
        return new ResponseEntity<>(
                countryCasesPerDateService.getCountryCasesPerDate(countryName, date),
                HttpStatus.OK);
    }
}
