package ct.frontend.integration.web.client;

import ct.frontend.integration.protobuf.Protos;
import ct.frontend.integration.web.HttpProps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountryCasesPerDateClient {

    private final HttpProps httpProps;

    public Protos.CasesPerDateCollection getCountryCasesPerDateCollection(String countryName) {
        return httpProps.getRestTemplate().getForObject(
                String.format(httpProps.getUrl() + "/countries/%s/cases-per-date", countryName),
                Protos.CasesPerDateCollection.class);
    }

    public Protos.CasesPerDate getCountryCasesPerDate(String countryName, String date) {
        return httpProps.getRestTemplate().getForObject(
                String.format(httpProps.getUrl() + "/countries/%s/cases-per-date/%s", countryName, date),
                Protos.CasesPerDate.class);
    }
}
