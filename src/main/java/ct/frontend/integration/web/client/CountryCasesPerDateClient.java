package ct.frontend.integration.web.client;

import ct.frontend.integration.config.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CasesPerDate;
import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CasesPerDateCollection;

@Component
@RequiredArgsConstructor
public class CountryCasesPerDateClient {

    private final RestTemplate restTemplate;
    private final AppProperties appProperties;

    public CasesPerDateCollection getCountryCasesPerDateCollection(String countryName) {
        return restTemplate.getForObject(
                String.format(appProperties.getClientUrl() + "/countries/%s/cases-per-date", countryName),
                CasesPerDateCollection.class);
    }

    public CasesPerDate getCountryCasesPerDate(String countryName, String date) {
        return restTemplate.getForObject(
                String.format(appProperties.getClientUrl() + "/countries/%s/cases-per-date/%s", countryName, date),
                CasesPerDate.class);
    }
}
