package ru.yaal.examples.database.hibernate.bidirectassosiation.people.bi;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.junit.Test;
import ru.yaal.examples.database.hibernate.bidirectassosiation.Factory;
import ru.yaal.examples.database.hibernate.bidirectassosiation.people.bi.Address;
import ru.yaal.examples.database.hibernate.bidirectassosiation.people.bi.People;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PeopleTest {

    @Test
    public void test() throws Exception {
        saveEntities();
        readEntities();
    }

    private void saveEntities() throws Exception {
        Session session = null;
        try {
            session = Factory.getSessionFactory().openSession();
            session.beginTransaction();

            People man = new People();
            People woman = new People();
            Set<People> peoples = new HashSet<>();
            peoples.add(man);
            peoples.add(woman);

            Address spb = new Address();
            Address moscow = new Address();
            Set<Address> addresses = new HashSet<>();
            addresses.add(moscow);
            addresses.add(spb);

            man.setAddresses(addresses);
            woman.setAddresses(addresses);
            moscow.setPeoples(peoples);
            spb.setPeoples(peoples);

            session.save(man);
            session.save(woman);
            session.save(moscow);
            session.save(spb);
            session.getTransaction().commit();
            session.flush();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private void readEntities() throws Exception {
        Session session = Factory.getSessionFactory().openSession();
        List<Address> allAddresses = session.createCriteria(Address.class).addOrder(Order.desc("id")).list();
        List<People> allPeoples = session.createCriteria(People.class).addOrder(Order.desc("id")).list();
        session.close();
    }
}