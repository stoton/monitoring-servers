package com.github.stoton.monitoring.repository;

import com.github.stoton.monitoring.domain.Server;

public interface ServerRepository {
    void save(Server server);
    Server server(String token);
}
