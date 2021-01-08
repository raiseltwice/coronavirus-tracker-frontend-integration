package ct.frontend.integration.service;

import com.google.protobuf.InvalidProtocolBufferException;
import ct.frontend.integration.web.client.StateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.State;
import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.States;

@Component
@RequiredArgsConstructor
public class StateService {

    private final StateClient stateClient;

    public States getStates(String countryName) {
        return stateClient.getStates(countryName);
    }

    public State getState(String countryName, String stateName) {
        return stateClient.getState(countryName, stateName);
    }
}
