package ct.frontend.integration.web.client;

import ct.frontend.integration.config.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.Countries;
import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.Country;

@Component
@RequiredArgsConstructor
public class CountryClient {

    private final RestTemplate restTemplate;
    private final AppProperties appProperties;

    public Countries getCountries() {
        return restTemplate.getForObject(appProperties.getClientUrl() + "/countries", Countries.class);
    }

    public Country getCountry(String countryName) {
        return restTemplate.getForObject(
                String.format(appProperties.getClientUrl() + "/countries/%s", countryName),
                Country.class);
    }
}
