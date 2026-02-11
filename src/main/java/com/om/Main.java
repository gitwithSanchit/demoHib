package com.om;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Dell");

        bacha s = new bacha();
        s.setName("Manuu");
        s.setRollno(1);
        s.setMarks(100);
        s.setLaptop(laptop);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        session.persist(s);
        session.persist(laptop);

        tx.commit();
        session.close();

        System.out.println("Saved!");
    }
}
