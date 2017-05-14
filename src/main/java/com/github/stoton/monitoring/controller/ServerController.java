package com.github.stoton.monitoring.controller;

import com.github.stoton.monitoring.domain.Server;
import com.github.stoton.monitoring.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    @Autowired
    private ServerRepository serverRepository;

    @PostMapping("/initServer")
    public void initServer(@RequestBody Server server) {
        serverRepository.save(server);
    }
}

