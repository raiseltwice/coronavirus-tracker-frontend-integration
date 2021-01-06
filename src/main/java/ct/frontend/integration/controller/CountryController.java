package ct.frontend.integration.controller;

import com.google.protobuf.InvalidProtocolBufferException;
import ct.frontend.integration.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = "application/json")
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/countries")
    public String getCountries() throws InvalidProtocolBufferException {
        return countryService.getCountries();
    }

    @GetMapping("/countries/{countryName}")
    public String getCountry(@PathVariable String countryName) throws InvalidProtocolBufferException {
        return countryService.getCountry(countryName);
    }
}
