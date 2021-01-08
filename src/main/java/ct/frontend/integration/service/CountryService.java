package ct.frontend.integration.service;

import com.google.protobuf.InvalidProtocolBufferException;
import ct.frontend.integration.web.client.CountryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.Countries;
import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.Country;

@Component
@RequiredArgsConstructor
public class CountryService {

    private final CountryClient countryClient;

    public Countries getCountries() {
        return countryClient.getCountries();
    }

    public Country getCountry(String countryName) {
        return countryClient.getCountry(countryName);
    }
}
