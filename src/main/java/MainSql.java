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

       contact.setId(6L);
       contact.setCustomerId(6);
       contact.setFirstName("Alex");
       contact.setLastName("Hiper");
       contact.setEmail("alex@mail.ru");
       contact.setPhone("89325562254");
       contact.setHireDate("1985-03-16");
       contact.setJobid("IPid");

        var entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.persist(user1);
        em.persist(contact);
        em.getTransaction().commit();
        em.close();
    }
}
