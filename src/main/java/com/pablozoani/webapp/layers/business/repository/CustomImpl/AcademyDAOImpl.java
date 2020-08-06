package com.pablozoani.webapp.layers.business.repository.CustomImpl;


import com.pablozoani.webapp.layers.business.repository.CustomImpl.base.BaseDAO;
import com.pablozoani.webapp.layers.model.Academy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Profile("custom")
@Repository
public class AcademyDAOImpl extends BaseDAO<Academy, Long>
        implements AcademyDAO {

    @Autowired
    public AcademyDAOImpl(EntityManagerFactory emf) {
        super(emf, Academy.class);
    }
}
