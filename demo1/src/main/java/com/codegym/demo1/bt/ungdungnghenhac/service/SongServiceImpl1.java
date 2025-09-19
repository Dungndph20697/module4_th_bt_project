package com.codegym.demo1.bt.ungdungnghenhac.service;

import com.codegym.demo1.bt.ungdungnghenhac.model.Song;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl1 implements ISongService1 {

    private static EntityManager entityManager;
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Song> findAll() {
        String queryStr = "SELECT s FROM Song AS s";
        TypedQuery<Song> query = entityManager.createQuery(queryStr, Song.class);
        return query.getResultList();
    }

    @Override
    public void save(Song song) {
        Transaction transaction = null;
        Song origin;
        if (song.getId() == 0) {
            origin = new Song();
        } else {
            origin = findById(song.getId());
        }
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            origin.setName(song.getName());
            origin.setArtist(song.getArtist());
            origin.setGenre(song.getGenre());
            origin.setLink(song.getLink());
            session.saveOrUpdate(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Song findById(Integer id) {
        String queryStr = "SELECT c FROM Song AS c WHERE c.id = :id";
        TypedQuery<Song> query = entityManager.createQuery(queryStr, Song.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void remove(Integer id) {
        Song song = findById(id);
        if (song != null) {
            Transaction transaction = null;
            try (Session session = sessionFactory.openSession()) {
                transaction = session.beginTransaction();
                session.remove(song);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                if (transaction != null) {
                    transaction.rollback();
                }
            }
        }
    }

    @Override
    public void update(Integer id, Song song) {
        Transaction transaction = null;
        Song origin;
        if (song.getId() == 0) {
            origin = new Song();
        } else {
            origin = findById(song.getId());
        }
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            origin.setId(song.getId());
            origin.setName(song.getName());
            origin.setArtist(song.getArtist());
            origin.setGenre(song.getGenre());
            origin.setLink(song.getLink());
            session.saveOrUpdate(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
