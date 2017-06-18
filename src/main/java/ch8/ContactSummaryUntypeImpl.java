package ch8;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

@Service("ContactSummaryUntypeImpl")
@Repository
@Transactional
public class ContactSummaryUntypeImpl {
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public void displayAllContactSummary(){
        List result = em.createQuery("select c.firstName, c.lastName, t.telNumber "
                + "from Contact с left join с. contactTelDetails t "
                + "where t.telТуре = ' Ноте'").getResultList();
        int count = 0;
        for (Iterator i = result.iterator(); i.hasNext();){
            Object[] values = (Object[]) i.next();
            System.out.println(++count + ": " + values[0] + ", " + values[1] + ", " + values[2]);
        }
    }
}