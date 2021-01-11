package ct.frontend.integration.web.client;

import ct.frontend.integration.config.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.StateDTO;
import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.StatesDTO;

@Component
@RequiredArgsConstructor
public class StateClient {

    private final RestTemplate restTemplate;
    private final AppProperties appProperties;

    public StatesDTO getStates(String countryName) {
        return restTemplate.getForObject(
                String.format(appProperties.getClientUrl() + "/countries/%s/states", countryName),
                StatesDTO.class);
    }

    public StateDTO getState(String countryName, String stateName) {
        return restTemplate.getForObject(
                String.format(appProperties.getClientUrl() + "/countries/%s/states/%s/", countryName, stateName),
                StateDTO.class);
    }
}
