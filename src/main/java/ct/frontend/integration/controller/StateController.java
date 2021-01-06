package ct.frontend.integration.controller;

import com.google.protobuf.InvalidProtocolBufferException;
import ct.frontend.integration.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = "application/json")
public class StateController {

    private final StateService stateService;

    @GetMapping("/countries/{countryName}/states")
    public String getStates(@PathVariable String countryName) throws InvalidProtocolBufferException {
        return stateService.getStates(countryName);
    }

    @GetMapping("/countries/{countryName}/states/{stateName}")
    public String getStateByName(@PathVariable String countryName,
                                  @PathVariable String stateName) throws InvalidProtocolBufferException {
        return stateService.getState(countryName, stateName);
    }
}
