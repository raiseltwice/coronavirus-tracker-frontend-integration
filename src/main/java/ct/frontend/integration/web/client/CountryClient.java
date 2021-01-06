package ct.frontend.integration.web.client;

import ct.coreapi.common.Protos;
import ct.frontend.integration.web.HttpProps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountryClient {

    private final HttpProps httpProps;

    public Protos.Countries getCountries() {
        return httpProps.getRestTemplate().getForObject(httpProps.getUrl() + "/countries", Protos.Countries.class);
    }

    public Protos.Country getCountry(String countryName) {
        return httpProps.getRestTemplate().getForObject(
                String.format(httpProps.getUrl() + "/countries/%s", countryName),
                Protos.Country.class);
    }
}
