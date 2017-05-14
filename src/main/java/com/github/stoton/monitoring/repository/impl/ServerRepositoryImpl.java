package com.github.stoton.monitoring.repository.impl;

import com.github.stoton.monitoring.domain.Server;
import com.github.stoton.monitoring.repository.ServerRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ServerRepositoryImpl implements ServerRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public void save(Server server) {
        getSession().save(server);
    }

    @Override
    public Server server(String token) {
        return (Server) getSession().createQuery("from " + Server.class.getName() + " where server_token = :server_token")
                .setParameter("server_token", token)
                .uniqueResult();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
