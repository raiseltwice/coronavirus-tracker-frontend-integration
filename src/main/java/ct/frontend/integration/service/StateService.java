package ct.frontend.integration.service;

import ct.frontend.integration.web.client.StateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.StateDTO;
import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.StatesDTO;

@Component
@RequiredArgsConstructor
public class StateService {

    private final StateClient stateClient;

    public StatesDTO getStates(String countryName) {
        return stateClient.getStates(countryName);
    }

    public StateDTO getState(String countryName, String stateName) {
        return stateClient.getState(countryName, stateName);
    }
}
