package dev.patika.service;

import dev.patika.models.Customer;
import dev.patika.repository.CrudRepository;
import dev.patika.repository.CustomerRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerService implements CrudRepository<Customer>, CustomerRepository {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Customer> findAll() {
        return em.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public Customer findById(int id) {
        return  em.find(Customer.class, id);
    }

    @Override
    public void saveToDatabase(Customer customer) {
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    @Override
    public void deleteFromDatabase(Customer object) {

    }

    @Override
    public void deleteFromDatabase(int id) {

    }

    @Override
    public void updateOnDatabase(Customer object) {

    }

    @Override
    public void deleteCustomerFromDatabase(long ssid) {
        em.getTransaction().begin();

        Customer customer = em.createQuery("from Customer c WHERE c.ssid =:ssid", Customer.class).setParameter("ssid", ssid).getSingleResult();
        em.remove(customer);

        em.getTransaction().commit();
    }
}
