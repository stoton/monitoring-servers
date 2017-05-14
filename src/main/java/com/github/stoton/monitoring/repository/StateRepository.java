package com.github.stoton.monitoring.repository;

import com.github.stoton.monitoring.domain.State;

import java.util.List;

public interface StateRepository  {
    void save(State state);
    List<State> getStatesWithLimit(long limit);
}
