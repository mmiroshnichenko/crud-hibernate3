package org.crudhibernate3.repository.impl;

import org.crudhibernate3.model.Label;
import org.crudhibernate3.repository.LabelRepository;
import org.crudhibernate3.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateLabelRepositoryImpl implements LabelRepository {
    @Override
    public Label getById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Label label = session.get(Label.class, id);
        transaction.commit();
        session.close();
        return label;
    }

    @Override
    public List<Label> getAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Label> labels = session.createQuery("FROM Label").list();
        transaction.commit();
        session.close();
        return labels;
    }

    @Override
    public Label save(Label label) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(label);
        transaction.commit();
        session.close();
        return label;
    }

    @Override
    public Label update(Label label) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(label);
        transaction.commit();
        session.close();
        return label;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Label label = session.get(Label.class, id);
        session.delete(label);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Label> getByIds(List<Long> ids) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Label WHERE id IN (?1)");
        query.setParameter(1, ids);
        List<Label> labels = query.getResultList();
        transaction.commit();
        session.close();
        return labels;
    }
}