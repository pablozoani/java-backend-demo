package com.pablozoani.webapp.layers.business.repository.CustomImpl;

import com.pablozoani.webapp.layers.business.repository.CustomImpl.base.BasePersonDAO;
import com.pablozoani.webapp.layers.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Profile("custom")
@Repository
public class InstructorDAOImpl extends BasePersonDAO<Instructor, Long>
        implements InstructorDAO {

    @Autowired
    public InstructorDAOImpl(EntityManagerFactory emf) {
        super(emf, Instructor.class);
    }
}
