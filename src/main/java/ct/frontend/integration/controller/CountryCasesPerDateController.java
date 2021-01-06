package ct.frontend.integration.controller;

import com.google.protobuf.InvalidProtocolBufferException;
import ct.frontend.integration.service.CountryCasesPerDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = "application/json")
public class CountryCasesPerDateController {

    private final CountryCasesPerDateService countryCasesPerDateService;

    @GetMapping("/countries/{countryName}/cases-per-date")
    public String getCountryCasesPerDateCollection(@PathVariable String countryName) throws InvalidProtocolBufferException {
        return countryCasesPerDateService.getCountryCasesPerDateCollection(countryName);
    }

    @GetMapping("/countries/{countryName}/cases-per-date/{date}")
    public String getCountryCasesPerDateByDate(@PathVariable String countryName,
                                               @PathVariable String date) throws InvalidProtocolBufferException {
        return countryCasesPerDateService.getCountryCasesPerDate(countryName, date);
    }
}
