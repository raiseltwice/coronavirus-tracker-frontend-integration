package ct.frontend.integration.web.client;

import ct.frontend.integration.config.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CasesPerDateDTO;
import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CasesPerDateCollectionDTO;

@Component
@RequiredArgsConstructor
public class StateCasesPerDateClient {

    private final RestTemplate restTemplate;
    private final AppProperties appProperties;

    public CasesPerDateCollectionDTO getStateCasesPerDateCollection(String countryName, String stateName) {
        return restTemplate.getForObject(
                String.format(appProperties.getClientUrl() + "/countries/%s/states/%s/cases-per-date", countryName, stateName),
                CasesPerDateCollectionDTO.class);
    }

    public CasesPerDateDTO getStateCasesPerDate(String countryName, String stateName, String date) {
        return restTemplate.getForObject(
                String.format(appProperties.getClientUrl() +
                        "/countries/%s/states/%s/cases-per-date/%s", countryName, stateName, date),
                CasesPerDateDTO.class);
    }
}
