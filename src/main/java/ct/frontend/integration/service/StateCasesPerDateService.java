package ct.frontend.integration.service;

import ct.frontend.integration.web.client.StateCasesPerDateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CasesPerDateCollectionDTO;
import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CasesPerDateDTO;

@Component
@RequiredArgsConstructor
public class StateCasesPerDateService {

    private final StateCasesPerDateClient stateCasesPerDateClient;

    public CasesPerDateCollectionDTO getStateCasesPerDateCollection(String countryName, String stateName) {
        return stateCasesPerDateClient.getStateCasesPerDateCollection(countryName, stateName);
    }

    public CasesPerDateDTO getStateCasesPerDate(String countryName, String stateName, String date) {
        return stateCasesPerDateClient.getStateCasesPerDate(countryName, stateName, date);
    }
}
