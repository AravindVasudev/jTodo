package io.github.aravindvasudev.jtodo.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TodoDBModel implements TodoDAO {
    public static final SessionFactory sessionFactory = new Configuration()
            .configure()
            .buildSessionFactory();
    private ObservableList<Todo> list = FXCollections.observableArrayList();

    @Override
    public void add(Todo todo) {
        list.add(todo);
    }

    @Override
    public void remove(Todo toDeleteTodo) {
        list.remove(toDeleteTodo);
    }

    @Override
    public void save() throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("delete from Todo").executeUpdate();
        session.getTransaction().commit();

        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        for (Todo todo : list) {
            session.save(todo);
        }

        session.getTransaction().commit();
        sessionFactory.close();
    }

    @Override
    public void load() throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        list.addAll(session.createQuery("from Todo").getResultList());
        session.getTransaction().commit();
    }

    @Override
    public ObservableList<Todo> getList() {
        return list;
    }
}