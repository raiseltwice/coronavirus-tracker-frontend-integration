package ct.frontend.integration.service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import ct.frontend.integration.protobuf.Protos;
import ct.frontend.integration.web.client.CountryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountryService {

    private final CountryClient countryClient;

    public String getCountries() throws InvalidProtocolBufferException {
        Protos.Countries countries = countryClient.getCountries();
        return JsonFormat.printer().includingDefaultValueFields().print(countries);
    }

    public String getCountry(String countryName) throws InvalidProtocolBufferException {
        Protos.Country country = countryClient.getCountry(countryName);
        return JsonFormat.printer().includingDefaultValueFields().print(country);
    }
}
