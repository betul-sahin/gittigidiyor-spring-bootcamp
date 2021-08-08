package dev.patika.clients;

import dev.patika.controller.CustomerController;
import dev.patika.models.*;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class InsuranceApiClient {
    public static void main(String[] args) {
       // saveTestData();
        CustomerController controller = new CustomerController();

        /*Customer customer4 = new Customer("Aleyna Kütük", "Istanbul", 6452545241L );
        controller.saveCustomer(customer4);*/
        controller.deleteCustomer(6452545241L);
        List<Customer> returnedList = controller.findAllCustomers();
        for (Customer customer : returnedList) {
            System.out.println(customer);
        }
    }

    private static void saveTestData() {

        Customer customer1 = new Customer("Koray Guney", "Istanbul", 321562365123L );
        Customer customer2 = new Customer("Ali Veli", "Ankara", 32132143246L );
        Customer customer3 = new Customer("Ayse Simsek", "Edirne", 6452533241L );

        Vehicle car1 = new Car(2020, "Porsche Cayenne", "34VG5677", "Red");
        Vehicle car2 = new Car(2017, "Toyota Corolla", "08HG234", "Black");
        Vehicle moto1 = new Motorcycle(2020, "Porsche Cayenne", "34VG5677", 120.0);

        car1.setCustomer(customer1);
        car2.setCustomer(customer2);
        moto1.setCustomer(customer3);

        Accident accident1 = new Accident(LocalDate.of(2021, Month.AUGUST,12));
        Accident accident2 = new Accident(LocalDate.of(2020, Month.JUNE,24));
        Accident accident3 = new Accident(LocalDate.of(2019, Month.MARCH,4));

        car1.getAccidents().add(accident1);
        car2.getAccidents().add(accident1);
        moto1.getAccidents().add(accident2);
        moto1.getAccidents().add(accident3);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();

            em.persist(car1);
            em.persist(car2);
            em.persist(moto1);

            em.persist(customer1);
            em.persist(customer2);
            em.persist(customer3);

            em.persist(accident1);
            em.persist(accident2);
            em.persist(accident3);

            em.getTransaction().commit();

            System.out.println("All data persisted...");
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }
}
