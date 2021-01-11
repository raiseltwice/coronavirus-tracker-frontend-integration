package ct.frontend.integration.controller;

import ct.frontend.integration.service.StateCasesPerDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CasesPerDateDTO;
import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CasesPerDateCollectionDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = "application/json")
public class StateCasesPerDateController {

    private final StateCasesPerDateService stateCasesPerDateService;

    @GetMapping("/countries/{countryName}/states/{stateName}/cases-per-date")
    public ResponseEntity<CasesPerDateCollectionDTO> getCountryCasesPerDateCollection(@PathVariable String countryName,
                                                                                   @PathVariable String stateName) {
        return new ResponseEntity<>(
                stateCasesPerDateService.getStateCasesPerDateCollection(countryName, stateName),
                HttpStatus.OK);
    }

    @GetMapping("/countries/{countryName}/states/{stateName}/cases-per-date/{date}")
    public ResponseEntity<CasesPerDateDTO> getStateCasesPerDate(@PathVariable String countryName,
                                                             @PathVariable String stateName,
                                                             @PathVariable String date) {
        return new ResponseEntity<>(
                stateCasesPerDateService.getStateCasesPerDate(countryName, stateName, date),
                HttpStatus.OK);
    }
}
