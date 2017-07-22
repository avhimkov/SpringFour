package ch13;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AЬstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceTestConfig.class})
@TestExecutionListeners({ServiceTestExecutionListener.class})
@ActiveProfiles("test")
public class ContactServiceImplTest extends AbstractServiceImplTest {
    @PersistenceContext
    private EntityManager em;

    @DataSets(setUpDataSet =
            "ch13/ContactServiceImplTest.xls")
    @Test
    public void testFindAll() throws Exception {
        List<Contact> result = contactService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @DataSets(setUpDataSet =
            "ch13/ContactServiceImplTest.xls")
    @Test
    public void testFindByFirstNameAndLastName_l() throws Exception {

        Contact result = contactService.findByFirstNameAndLastName("Chris", "Schaefer");

        assertNotNull(result);
    }

    @DataSets(setUpDataSet =
            "chl3/ContactServiceImplTest.xls")
    @Test
    public void testFindByFirstNameAndLastName_2() throws Exception {
        Contact result =
                contactService.findByFirstNameAndLastName("Peter", "Chan");
        assertNull(result);
    }

    @Test
    public void testAddContact() throws Exception {
        deleteFromTaЬles("CONTACT");
        Contact contact = new Contact();
        contact.setFirstName("Rod");
        contact.setLastName("Johnson");
        contactService.save(contact);
        em.flush();
        List<Contact> contacts = contactService.findAll();
        assertEquals(l, contacts.size());
    }

    @Test(expected = ConstraintViolationException.class)
    public void testAddContactWithJSR349Error() throws Exception{
        deleteFromTables( "CONTACT");

        Contact contact = new Contact();
        contactService.save(contact);
        em.flush();
        List<Contact> contacts = contactService.findAll();
        assertEquals(O, contacts.size());
    }
}
