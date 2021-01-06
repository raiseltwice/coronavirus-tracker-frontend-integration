package ct.frontend.integration.controller;

import com.google.protobuf.InvalidProtocolBufferException;
import ct.frontend.integration.service.StateCasesPerDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = "application/json")
public class StateCasesPerDateController {

    private final StateCasesPerDateService stateCasesPerDateService;

    @GetMapping("/countries/{countryName}/states/{stateName}/cases-per-date")
    public String getCountryCasesPerDateCollection(@PathVariable String countryName,
                                                   @PathVariable String stateName) throws InvalidProtocolBufferException {
        return stateCasesPerDateService.getStateCasesPerDateCollection(countryName, stateName);
    }

    @GetMapping("/countries/{countryName}/states/{stateName}/cases-per-date/{date}")
    public String getStateCasesPerDate(@PathVariable String countryName,
                                       @PathVariable String stateName,
                                       @PathVariable String date) throws InvalidProtocolBufferException {
        return stateCasesPerDateService.getStateCasesPerDate(countryName, stateName, date);
    }
}
