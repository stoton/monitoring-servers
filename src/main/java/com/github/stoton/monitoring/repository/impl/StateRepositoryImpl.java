package com.github.stoton.monitoring.repository.impl;


import com.github.stoton.monitoring.domain.State;
import com.github.stoton.monitoring.repository.StateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StateRepositoryImpl implements StateRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(State state) {
        getSession().save(state);
    }

    @Override
    public List<State> getStatesWithLimit(long limit) {
        return getSession().createQuery("from " + State.class.getName() + " order by id desc")
                .setMaxResults((int)limit)
                .list();
    }

     private Session getSession() {
        return sessionFactory.getCurrentSession();
     }
}
