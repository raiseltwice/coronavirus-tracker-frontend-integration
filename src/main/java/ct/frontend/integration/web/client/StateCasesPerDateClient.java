package ct.frontend.integration.web.client;

import ct.coreapi.common.Protos;
import ct.frontend.integration.web.HttpProps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StateCasesPerDateClient {

    private final HttpProps httpProps;

    public Protos.CasesPerDateCollection getStateCasesPerDateCollection(String countryName, String stateName) {
        return httpProps.getRestTemplate().getForObject(
                String.format(httpProps.getUrl() + "/countries/%s/states/%s/cases-per-date", countryName, stateName),
                Protos.CasesPerDateCollection.class);
    }

    public Protos.CasesPerDate getStateCasesPerDate(String countryName, String stateName, String date) {
        return httpProps.getRestTemplate().getForObject(
                String.format(httpProps.getUrl() +
                        "/countries/%s/states/%s/cases-per-date/%s", countryName, stateName, date),
                Protos.CasesPerDate.class);
    }
}
