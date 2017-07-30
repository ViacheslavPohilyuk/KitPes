package org.kitpes.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by mac on 26.06.17.
 */
@Component
public class SessionExecutor {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void updateSession(Consumer<Session> updateStmt) {
        try {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            updateStmt.accept(session); // update operation
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public <T> T readSession(Function<Session, T> readStmt) {
        T result = null;
        try {
            Session session = sessionFactory.openSession();
            result = readStmt.apply(session); // read data operation
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return result;
    }
}
