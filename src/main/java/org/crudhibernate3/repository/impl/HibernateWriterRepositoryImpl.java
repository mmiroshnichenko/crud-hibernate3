package org.crudhibernate3.repository.impl;

import org.crudhibernate3.model.Writer;
import org.crudhibernate3.repository.WriterRepository;
import org.crudhibernate3.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateWriterRepositoryImpl implements WriterRepository {
    @Override
    public Writer getById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Writer writer = session.get(Writer.class, id);
        transaction.commit();
        session.close();
        return writer;
    }

    @Override
    public List<Writer> getAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Writer> writers = session.createQuery("FROM Writer").list();
        transaction.commit();
        session.close();
        return writers;
    }

    @Override
    public Writer save(Writer writer) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(writer);
        transaction.commit();
        session.close();
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(writer);
        transaction.commit();
        session.close();
        return writer;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Writer writer = session.get(Writer.class, id);
        session.delete(writer);
        transaction.commit();
        session.close();
    }
}
