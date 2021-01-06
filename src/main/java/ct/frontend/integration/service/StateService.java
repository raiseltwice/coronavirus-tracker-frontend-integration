package ct.frontend.integration.service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import ct.frontend.integration.protobuf.Protos;
import ct.frontend.integration.web.client.CountryClient;
import ct.frontend.integration.web.client.StateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StateService {

    private final StateClient stateClient;

    public String getStates(String countryName) throws InvalidProtocolBufferException {
        Protos.States countries = stateClient.getStates(countryName);
        return JsonFormat.printer().includingDefaultValueFields().print(countries);
    }

    public String getState(String countryName, String stateName) throws InvalidProtocolBufferException {
        Protos.State state = stateClient.getState(countryName, stateName);
        return JsonFormat.printer().includingDefaultValueFields().print(state);
    }
}
