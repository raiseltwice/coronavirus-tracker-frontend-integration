package ct.frontend.integration.web.client;

import ct.frontend.integration.protobuf.Protos;
import ct.frontend.integration.web.HttpProps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StateClient {

    private final HttpProps httpProps;

    public Protos.States getStates(String countryName) {
        return httpProps.getRestTemplate().getForObject(
                String.format(httpProps.getUrl() + "/countries/%s/states", countryName),
                Protos.States.class);
    }

    public Protos.State getState(String countryName, String stateName) {
        return httpProps.getRestTemplate().getForObject(
                String.format(httpProps.getUrl() + "/countries/%s/states/%s/", countryName, stateName),
                Protos.State.class);
    }
}
