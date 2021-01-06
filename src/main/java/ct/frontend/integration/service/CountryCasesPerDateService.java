package ct.frontend.integration.service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import ct.coreapi.common.Protos;
import ct.frontend.integration.web.client.CountryCasesPerDateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountryCasesPerDateService {

    private final CountryCasesPerDateClient countryCasesPerDateClient;

    public String getCountryCasesPerDateCollection(String countryName) throws InvalidProtocolBufferException {
        Protos.CasesPerDateCollection casesPerDate = countryCasesPerDateClient.getCountryCasesPerDateCollection(countryName);
        return JsonFormat.printer().includingDefaultValueFields().print(casesPerDate);
    }

    public String getCountryCasesPerDate(String countryName, String date) throws InvalidProtocolBufferException {
        Protos.CasesPerDate casesPerDate = countryCasesPerDateClient.getCountryCasesPerDate(countryName, date);
        return JsonFormat.printer().includingDefaultValueFields().print(casesPerDate);
    }
}
