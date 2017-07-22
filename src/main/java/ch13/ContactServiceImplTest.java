package ch13;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AЬstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceTestConfig.class})
@TestExecutionListeners({ServiceTestExecutionListener.class})
@ActiveProfiles("test")
public class ContactServiceImplTest extends AbstractTransactionalJUnit4SpringContextтests {
    @Autowired
    ContactService contactService;

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

    @DataSets(setUpDataSet=
            "chl3/ContactServiceImplTest.xls")
    @Test
    public void testFindByFirstNameAndLastName_2() throws Exception {
        Contact result =
                contactService.findByFirstNameAndLastName("Peter", "Chan");
        assertNull(result);
    }
}
