import ch.qos.logback.core.encoder.JsonEscapeUtil;
import models.Contact;
import models.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MainSql {
    public static void main(String[] args) {
        User user1 = new User();
       user1.setName("Alex");

       Contact contact = new Contact();

       contact.setCustomerId(6);
       contact.setFirstName("Alex");
       contact.setLastName("Hiper");


        var entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.persist(user1);
        em.persist(contact);
        em.getTransaction().commit();
        em.close();
    }
}
