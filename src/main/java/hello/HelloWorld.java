package hello;
import com.mkyong.util.HibernateUtil;

import java.util.*;
import javax.persistence.*;
public class HelloWorld {

    public static void main(String[] args) {

// First unit of work
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Message message = new Message("Hello World");
        em.persist(message);
        tx.commit();
        em.close();

// Second unit of work
        EntityManager newEm = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction newTx = newEm.getTransaction();
        newTx.begin();
        List messages = newEm
                .createQuery("select m from Message m order by m.text asc")
                .getResultList();
        System.out.println( messages.size() + " message(s) found" );
        for (Object m : messages) {
            Message loadedMsg = (Message) m;
            System.out.println(loadedMsg.getText());
        }
        newTx.commit();
        newEm.close();

// Shutting down the application
        HibernateUtil.shutdown();
    }
}
