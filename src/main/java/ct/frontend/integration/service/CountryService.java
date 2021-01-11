package ct.frontend.integration.service;

import ct.frontend.integration.web.client.CountryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CountriesDTO;
import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CountryDTO;

@Component
@RequiredArgsConstructor
public class CountryService {

    private final CountryClient countryClient;

    public CountriesDTO getCountries() {
        return countryClient.getCountries();
    }

    public CountryDTO getCountry(String countryName) {
        return countryClient.getCountry(countryName);
    }
}
