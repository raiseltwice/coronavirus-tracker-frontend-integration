package ct.frontend.integration.web.client;

import ct.frontend.integration.config.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CasesPerDateDTO;
import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CasesPerDateCollectionDTO;

@Component
@RequiredArgsConstructor
public class CountryCasesPerDateClient {

    private final RestTemplate restTemplate;
    private final AppProperties appProperties;

    public CasesPerDateCollectionDTO getCountryCasesPerDateCollection(String countryName) {
        return restTemplate.getForObject(
                String.format(appProperties.getClientUrl() + "/countries/%s/cases-per-date", countryName),
                CasesPerDateCollectionDTO.class);
    }

    public CasesPerDateDTO getCountryCasesPerDate(String countryName, String date) {
        return restTemplate.getForObject(
                String.format(appProperties.getClientUrl() + "/countries/%s/cases-per-date/%s", countryName, date),
                CasesPerDateDTO.class);
    }
}
