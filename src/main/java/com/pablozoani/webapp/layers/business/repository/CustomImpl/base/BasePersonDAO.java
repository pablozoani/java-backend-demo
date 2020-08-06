package com.pablozoani.webapp.layers.business.repository.CustomImpl.base;

import com.pablozoani.webapp.layers.model.base.Person;
import com.pablozoani.webapp.layers.model.base.Person_;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Slf4j
public abstract class BasePersonDAO<T extends Person, ID extends Serializable>
        extends BaseDAO<T, ID> implements PersonDAO<T, ID> {

    public BasePersonDAO(EntityManagerFactory emf, Class<T> entityClass) {
        super(emf, entityClass);
    }

    public Iterable<T> findByRegistrationDateBetween(LocalDate date1, LocalDate date2) {

        CriteriaQuery<T> cq = cb.createQuery(entityClass);

        Root<T> root = cq.from(entityClass);

        cq.select(root).where(cb.between(root.get(Person_.registrationDate), date1, date2));

        EntityManager em = emf.createEntityManager();

        List<T> output = em.createQuery(cq).getResultList();

        em.close();

        return output;
    }

    public Iterable<T> findByRegistrationDateGreaterThanEqual(LocalDate date) {
        return findByRegistrationDateBetween(date, LocalDate.of(5000, 1, 1));
    }

    public Iterable<T> findByRegistrationDateLessThanEqual(LocalDate date) {
        return findByRegistrationDateBetween(LocalDate.of(1970, 1, 1), date);
    }
}
