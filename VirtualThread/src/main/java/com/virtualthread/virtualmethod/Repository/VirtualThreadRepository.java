package com.virtualthread.virtualmethod.Repository;

import com.virtualthread.virtualmethod.Domain.Vthr;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class VirtualThreadRepository {

    private final EntityManager em;


    public List<Vthr> findOne(){
        String jpql = "select v from vthr v";
        return em.createQuery( jpql ).getResultList();

    }

    public List<Vthr> findOneBlock(){
        em.createNativeQuery("SELECT SLEEP(1)").getResultList();
        return null;
    }

}
