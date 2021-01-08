package ct.frontend.integration.web.client;

import ct.frontend.integration.config.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.State;
import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.States;

@Component
@RequiredArgsConstructor
public class StateClient {

    private final RestTemplate restTemplate;
    private final AppProperties appProperties;

    public States getStates(String countryName) {
        return restTemplate.getForObject(
                String.format(appProperties.getClientUrl() + "/countries/%s/states", countryName),
                States.class);
    }

    public State getState(String countryName, String stateName) {
        return restTemplate.getForObject(
                String.format(appProperties.getClientUrl() + "/countries/%s/states/%s/", countryName, stateName),
                State.class);
    }
}
