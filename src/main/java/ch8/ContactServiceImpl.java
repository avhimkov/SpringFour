package ch8;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;

@Service("jpaContactService")
@Resource
@Transactional
public class ContactServiceImpl implements ContactService{
    private Log log = LogFactory.getLog(ContactServiceImpl.class);
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAll() {
        List<Contact> contacts = em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAllWithDetail() {
        List<Contact> contacts = em.createNamedQuery("Contact.findAllWithDetail", Contact.class).getResultList();
        return contacts;
    }

    @Transactional(readOnly = true)
    @Override
    public Contact findById(Long id) {
        TypedQuery<Contact> query = em.createNamedQuery("Contatc.findById", Contact.class);
        query.setParameter("id", id);
        return query.getSingleResult();

    }

    @Override
    public Contact save(Contact contact) {
        if (contact.getId()==null){
            log.info("Inserting new contact");
            em.persist(contact);
        } else {
            em.merge(contact);
            log.info("Updating existing contact");
        }
        log.info("Contact saved with id: " + contact.getId());
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        Contact mergedContact = em.merge(contact);
        em.remove(mergedContact);

        log.info("Contact with id: " + contact.getId() + "deleted successfully");
    }
}
