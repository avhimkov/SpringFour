package ch6;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("contactDao")
public class JdbcContactDao implements ContactDao {
    private static final Log LOG = LogFactory.getLog(JdbcContactDao.class);

    private DataSource dataSource;
    private SelectAllContacts selectAllContacts;
    private SelectContactByFirstName selectContactByFirstName;
    private UpdateContact updateContact;

    @Override
    public List<Contact> findAll(){
        return selectAllContacts.execute();
    }

    @Override
    public List<Contact> findByFirstName(String firstname){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("first_name", firstname);
        return selectContactByFirstName.executeByNamedParam(paramMap);
    }

    @Override
    public String findFirstNameById(Long id){
        return null;
    }

    @Override
    public List<Contact> findAllWithDetail() {
        return null;
    }

    @Override
    public void insert (Contact contact){
    }

    @Override
    public void insertWithDetail(Contact contact) {

    }

    @Override
    public void update(Contact contact){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("first_name", contact.getFirstName());
        paramMap.put("last_name", contact.getLastName());
        paramMap.put("birth_date", contact.getBirthDate());
        paramMap.put("id", contact.getId());

        updateContact.updateByNamedParam(paramMap);

        LOG.info("Existing contact updated wi th id: " + contact.getId());
    }

    @Override
    public void delete(Long contactId) {

    }

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllContacts = new SelectAllContacts(dataSource);
        this.selectContactByFirstName = new SelectContactByFirstName(dataSource);
        this.updateContact = new UpdateContact(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
