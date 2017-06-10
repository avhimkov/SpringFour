package ch8;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("jpaContactService")
@Resource
@Transactional
public class ContactServiceImpl implements ContactService{
    private Log log = LogFactory.getLog(ContactServiceImpl.class);
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Contact> findAll() {
        return null;
    }

    @Override
    public List<Contact> findAllWithDetail() {
        return null;
    }

    @Override
    public Contact findByid(Long id) {
        return null;
    }

    @Override
    public Contact save(Contact contact) {
        return null;
    }

    @Override
    public void delete(Contact contact) {

    }
}
