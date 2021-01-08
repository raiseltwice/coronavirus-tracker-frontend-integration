package ct.frontend.integration.service;

import com.google.protobuf.InvalidProtocolBufferException;
import coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos;
import ct.frontend.integration.web.client.StateCasesPerDateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CasesPerDateCollection;

@Component
@RequiredArgsConstructor
public class StateCasesPerDateService {

    private final StateCasesPerDateClient stateCasesPerDateClient;

    public CasesPerDateCollection getStateCasesPerDateCollection(String countryName, String stateName) {
        return stateCasesPerDateClient.getStateCasesPerDateCollection(countryName, stateName);
    }

    public CoronavirusTrackerCoreProtos.CasesPerDate getStateCasesPerDate(String countryName,
                                                                          String stateName,
                                                                          String date) {
        return stateCasesPerDateClient.getStateCasesPerDate(countryName, stateName, date);
    }
}
