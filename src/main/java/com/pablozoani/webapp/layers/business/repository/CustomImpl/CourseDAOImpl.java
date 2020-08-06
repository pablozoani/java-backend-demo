package com.pablozoani.webapp.layers.business.repository.CustomImpl;

import com.pablozoani.webapp.layers.business.repository.CustomImpl.base.BaseDAO;
import com.pablozoani.webapp.layers.model.Course;
import com.pablozoani.webapp.layers.model.Course_;
import com.pablozoani.webapp.layers.model.base.FieldOfStudy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static com.pablozoani.utils.ConsoleColors.BLUE;
import static com.pablozoani.utils.ConsoleColors.RESET;

@Slf4j
@Profile("custom")
@Repository
public class CourseDAOImpl extends BaseDAO<Course, Long>
        implements CourseDAO {

    @Autowired
    public CourseDAOImpl(EntityManagerFactory emf) {
        super(emf, Course.class);
    }

    @Override
    public Iterable<Course> findByField(FieldOfStudy field) {

        log.info(BLUE + "findByField()" + RESET);

        CriteriaQuery<Course> cq = cb.createQuery(entityClass);

        Root<Course> root = cq.from(entityClass);

        cq.select(root).where(cb.equal(root.get(Course_.field), field));

        EntityManager em = emf.createEntityManager();

        List<Course> output = em.createQuery(cq).getResultList();

        em.close();

        return output;
    }
}
