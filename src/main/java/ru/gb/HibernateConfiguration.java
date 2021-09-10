package ru.gb;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Profile("xml")
@Configuration

public class HibernateConfiguration {

    @Bean
    public EntityManagerFactory emFactory(){
         return new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    }

    @Bean
    public EntityManager entityManager(){
        return  emFactory().createEntityManager();
    }
}
