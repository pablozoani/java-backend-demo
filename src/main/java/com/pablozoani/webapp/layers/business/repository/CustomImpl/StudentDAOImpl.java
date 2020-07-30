package com.pablozoani.webapp.layers.business.repository.CustomImpl;

import com.pablozoani.webapp.layers.business.repository.CustomImpl.base.BasePersonDAO;
import com.pablozoani.webapp.layers.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Profile("custom")
@Repository
public class StudentDAOImpl extends BasePersonDAO<Student, Long>
    implements StudentDAO {

    @Autowired
    public StudentDAOImpl(EntityManagerFactory emf) {
        super(emf, Student.class);
    }
}
