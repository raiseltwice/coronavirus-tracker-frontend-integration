package ct.frontend.integration.service;

import ct.frontend.integration.web.client.CountryCasesPerDateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CasesPerDateCollectionDTO;
import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CasesPerDateDTO;

@Component
@RequiredArgsConstructor
public class CountryCasesPerDateService {

    private final CountryCasesPerDateClient countryCasesPerDateClient;

    public CasesPerDateCollectionDTO getCountryCasesPerDateCollection(String countryName) {
        return countryCasesPerDateClient.getCountryCasesPerDateCollection(countryName);
    }

    public CasesPerDateDTO getCountryCasesPerDate(String countryName, String date) {
        return countryCasesPerDateClient.getCountryCasesPerDate(countryName, date);
    }
}
