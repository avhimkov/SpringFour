package ch9;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact finddById(Long id) {
        return null;
    }

    @Override
    public Contact save(Contact contact) {
        return null;
    }

    @Override
    public long contactAll() {
        return 0;
    }
}
