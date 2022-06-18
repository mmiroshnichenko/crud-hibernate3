package org.crudhibernate3.repository.impl;

import org.crudhibernate3.model.Post;
import org.crudhibernate3.repository.PostRepository;
import org.crudhibernate3.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;

public class HibernatePostRepositoryImpl implements PostRepository {

    @Override
    public Post getById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Post p LEFT JOIN FETCH p.labels WHERE p.id = ?1" );
        query.setParameter(1, id);
        Post post = (Post) query.getSingleResult();
        session.close();
        return post;
    }

    @Override
    public List<Post> getAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Post> posts = session.createQuery("FROM Post").list();
        transaction.commit();
        session.close();
        return posts;
    }

    @Override
    public Post save(Post post) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(post);
        transaction.commit();
        session.close();
        return post;
    }

    @Override
    public Post update(Post post) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(post);
        transaction.commit();
        session.close();
        return post;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Post post = session.get(Post.class, id);
        session.delete(post);
        transaction.commit();
        session.close();
    }
}
