package ct.frontend.integration.controller;

import com.google.protobuf.InvalidProtocolBufferException;
import coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos;
import ct.frontend.integration.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.StatesDTO;
import static coronavirus.tracker.core.api.CoronavirusTrackerCoreProtos.StateDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = "application/json")
public class StateController {

    private final StateService stateService;

    @GetMapping("/countries/{countryName}/states")
    public ResponseEntity<StatesDTO> getStates(@PathVariable String countryName) {
        return new ResponseEntity<>(stateService.getStates(countryName), HttpStatus.OK);
    }

    @GetMapping("/countries/{countryName}/states/{stateName}")
    public ResponseEntity<StateDTO> getStateByName(@PathVariable String countryName,
                                                 @PathVariable String stateName) {
        return new ResponseEntity<>(stateService.getState(countryName, stateName), HttpStatus.OK);
    }
}
