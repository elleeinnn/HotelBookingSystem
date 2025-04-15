package com.hotel;

import db.HibernateUtil;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            User user = new User();
            user.setName("Test User");
            user.setEmail("test@example.com");

            session.save(user);

            transaction.commit();
            System.out.println("Користувача збережено у базу!");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }
}
