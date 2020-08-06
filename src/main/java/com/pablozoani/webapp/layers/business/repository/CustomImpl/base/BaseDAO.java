package com.pablozoani.webapp.layers.business.repository.CustomImpl.base;

import com.pablozoani.webapp.layers.model.base.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.pablozoani.utils.ConsoleColors.BLUE;
import static com.pablozoani.utils.ConsoleColors.RESET;

@Slf4j
public abstract class BaseDAO<T extends BaseEntity, ID extends Serializable>
        implements CrudRepository<T, ID> {

    protected final EntityManagerFactory emf;

    protected final Class<T> entityClass;

    protected CriteriaBuilder cb;

    public BaseDAO(EntityManagerFactory emf, Class<T> entityClass) {

        this.emf = emf;

        this.entityClass = entityClass;
    }

    @PostConstruct
    public void init() {
        this.cb = emf.getCriteriaBuilder();
    }

    @Override
    public <S extends T> S save(S entity) {

        log.info(BLUE + "save()" + RESET);

        EntityManager em = null;

        EntityTransaction tx = null;

        try {

            em = emf.createEntityManager();

            tx = em.getTransaction();

            tx.begin();

            entity = em.merge(entity);

            tx.commit();

        } catch (Exception ex) {

            try {

                if (tx != null && tx.isActive()) tx.rollback();

            } catch (Exception exc) {

                System.err.println("Rollback of transaction failed");

                exc.printStackTrace();
            }

            throw new RuntimeException(ex);

        } finally {

            if (em != null) em.close(); // <-- OUT
        }

        return entity;
    }

    @Override
    public <S extends T> Iterable<S> saveAll(@NonNull Iterable<S> entities) {

        log.info(BLUE + "saveAll()" + RESET);

        Set<S> output = new HashSet<>();

        entities.forEach(e -> output.add(save(e)));

        return output;
    }

    @Override
    public Optional<T> findById(ID id) {

        log.info(BLUE + "findById()" + RESET);

        EntityManager em = emf.createEntityManager();

        T t = em.find(entityClass, id);

        em.close();

        return Optional.ofNullable(t);
    }

    @Override
    public boolean existsById(ID id) {

        log.info(BLUE + "existsById()" + RESET);

        return findById(id).isPresent();
    }

    @Override
    public Iterable<T> findAll() {

        log.info(BLUE + "findAll()" + RESET);

        EntityManager em = emf.createEntityManager();

        String query = "FROM " + entityClass.getName();

        List<T> output = em.createQuery(query, entityClass).getResultList();

        em.close();

        return output;
    }

    @Override
    public Iterable<T> findAllById(Iterable<ID> ids) {

        log.info(BLUE + "findAllById()" + RESET);

        Set<T> output = new HashSet<>();

        ids.forEach(id -> findById(id).ifPresent(output::add));

        return output;
    }

    @Override
    public long count() {

        log.info(BLUE + "count()" + RESET);

        EntityManager em = emf.createEntityManager();

        String query = "SELECT COUNT(e) FROM " + entityClass.getName() + " e";

        Long output = em.createQuery(query, Long.class).getSingleResult();

        em.close();

        return output;
    }

    @Override
    public void deleteById(ID id) {

        log.info(BLUE + "deleteById()" + RESET);

        findById(id).ifPresent(this::delete);
    }

    @Override
    public void delete(@NonNull T entity) {

        log.info(BLUE + "delete()" + RESET);

        EntityManager em = null;

        EntityTransaction tx = null;

        try {

            em = emf.createEntityManager();

            tx = em.getTransaction();

            tx.begin();

            em.remove(em.contains(entity) ? entity : em.merge(entity));

            tx.commit();

        } catch (Exception ex) {

            try {

                if (tx != null && tx.isActive()) tx.rollback();

            } catch (Exception exc) {

                System.err.println("Rollback of transaction failed");

                exc.printStackTrace();
            }

            throw new RuntimeException(ex);

        } finally {

            if (em != null) em.close();
        }
    }

    @Override
    public void deleteAll(@NonNull Iterable<? extends T> entities) {

        log.info(BLUE + "deleteAll(Iterable<? extends T>)" + RESET);

        entities.forEach(this::delete);
    }

    @Override
    public void deleteAll() {

        log.info(BLUE + "deleteAll()" + RESET);

        findAll().forEach(this::delete);
    }
}
