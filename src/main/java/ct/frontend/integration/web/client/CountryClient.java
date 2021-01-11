package ct.frontend.integration.web.client;

import ct.frontend.integration.config.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CountriesDTO;
import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CountryDTO;

@Component
@RequiredArgsConstructor
public class CountryClient {

    private final RestTemplate restTemplate;
    private final AppProperties appProperties;

    public CountriesDTO getCountries() {
        return restTemplate.getForObject(appProperties.getClientUrl() + "/countries", CountriesDTO.class);
    }

    public CountryDTO getCountry(String countryName) {
        return restTemplate.getForObject(
                String.format(appProperties.getClientUrl() + "/countries/%s", countryName),
                CountryDTO.class);
    }
}
