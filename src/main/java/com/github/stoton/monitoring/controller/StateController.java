package com.github.stoton.monitoring.controller;

import com.github.stoton.monitoring.domain.Server;
import com.github.stoton.monitoring.domain.State;
import com.github.stoton.monitoring.repository.ServerRepository;
import com.github.stoton.monitoring.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private ServerRepository serverRepository;

    @GetMapping("/state/last/{limit}")
    public List<State> getStatesWithLimit(@PathVariable Integer limit) {
        return stateRepository.getStatesWithLimit(limit);
    }

    @PostMapping("/state/{token}")
    public void saveState(@RequestBody State state, @PathVariable String token) {
        state.setServer(serverRepository.server(token));
        stateRepository.save(state);
    }
}
