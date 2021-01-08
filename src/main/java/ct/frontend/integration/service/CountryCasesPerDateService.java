package ct.frontend.integration.service;

import com.google.protobuf.InvalidProtocolBufferException;
import coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos;
import ct.frontend.integration.web.client.CountryCasesPerDateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.CasesPerDateCollection;

@Component
@RequiredArgsConstructor
public class CountryCasesPerDateService {

    private final CountryCasesPerDateClient countryCasesPerDateClient;

    public CasesPerDateCollection getCountryCasesPerDateCollection(String countryName) {
        return countryCasesPerDateClient.getCountryCasesPerDateCollection(countryName);
    }

    public CoronavirusTrackerCoreProtos.CasesPerDate getCountryCasesPerDate(String countryName, String date) {
        return countryCasesPerDateClient.getCountryCasesPerDate(countryName, date);
    }
}
