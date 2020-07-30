package com.pablozoani.webapp.layers.business.repository;


import com.pablozoani.webapp.layers.business.repository.base.BaseDAO;
import com.pablozoani.webapp.layers.model.Academy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
public class AcademyDAOImpl extends BaseDAO<Academy, Long>
    implements AcademyDAO {

    @Autowired
    public AcademyDAOImpl(EntityManagerFactory emf) {
        super(emf, Academy.class);
    }
}
