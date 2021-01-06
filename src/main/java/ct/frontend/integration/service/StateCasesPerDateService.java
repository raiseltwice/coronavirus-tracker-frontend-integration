package ct.frontend.integration.service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import ct.frontend.integration.protobuf.Protos;
import ct.frontend.integration.web.client.StateCasesPerDateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StateCasesPerDateService {

    private final StateCasesPerDateClient stateCasesPerDateClient;

    public String getStateCasesPerDateCollection(String countryName, String stateName) throws InvalidProtocolBufferException {
        Protos.CasesPerDateCollection casesPerDateCollection = stateCasesPerDateClient.getStateCasesPerDateCollection(countryName, stateName);
        return JsonFormat.printer().includingDefaultValueFields().print(casesPerDateCollection);
    }

    public String getStateCasesPerDate(String countryName, String stateName, String date) throws InvalidProtocolBufferException {
        Protos.CasesPerDate casesPerDate = stateCasesPerDateClient.getStateCasesPerDate(countryName, stateName, date);
        return JsonFormat.printer().includingDefaultValueFields().print(casesPerDate);
    }
}
