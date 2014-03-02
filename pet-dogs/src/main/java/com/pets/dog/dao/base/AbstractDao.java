package com.pets.dog.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

/**
 * @author astha
 * @param <E>
 * @param <I>
 */
public interface AbstractDao<E, I extends Serializable> {

    public E findById(I id);
    public void saveOrUpdate(E e);
    public void delete(E e);
    public List<E> findByCriteria(Criterion criterion);
    public List<E> findAll();
}
