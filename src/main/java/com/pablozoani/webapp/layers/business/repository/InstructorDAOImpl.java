package com.pablozoani.webapp.layers.business.repository;

import com.pablozoani.webapp.layers.business.repository.base.BasePersonDAO;
import com.pablozoani.webapp.layers.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
public class InstructorDAOImpl extends BasePersonDAO<Instructor, Long>
    implements InstructorDAO {

    @Autowired
    public InstructorDAOImpl(EntityManagerFactory emf) {
        super(emf, Instructor.class);
    }
}
