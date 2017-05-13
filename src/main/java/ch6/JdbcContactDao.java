package ch6;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("contactDao")
public class JdbcContactDao implements ContactDao {
    private Log log = LogFactory.getLog(JdbcContactDao.class);

    private DataSource dataSource;
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
//        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
//        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        if (dataSource == null) {
//            throw new BeanCreationException("Must set dataSource on ContactDao");
//        }
//        if (namedParameterJdbcTemplate == null) {
//            throw new BeanCreationException("Null namedParameterJdbcTemplate on ContactDao");
//        }
//    }
//
//    @Override
//    public String findLastNameById(Long id) {
//        String sql = "select last_name from contact where id = :contactId";
//        Map<String, Object> nameParametrs = new HashMap<String, Object>();
//        nameParametrs.put("contactId", id);
//
//        return namedParameterJdbcTemplate.queryForObject(sql, nameParametrs, String.class);
//    }
//
//    @Override
//    public List<Contact> findAllWithDetail() {
//        String sql = "select c.id, c.first_name, c.last_name, c.birth_date" +
//                ", t.id as contact_tel_id, t.tel_type, t.tel_numЬer from contact с " +
//                "left join contact_tel_detail t on c.id = t.contact_id";
//        return namedParameterJdbcTemplate.query(sql, new ContactWithDeatailExtractor());
//    }
//
//    public static final class ContactWithDeatailExtractor implements ResultSetExtractor<List<Contact>> {
//        @Override
//        public List<Contact> extractData(ResultSet rs) throws SQLException, DataAccessException {
//            Map<Long, Contact> map = new HashMap<Long, Contact>();
//            Contact contact = null;
//            while (rs.next()) {
//                Long id = rs.getLong("id");
//                contact = map.get(id);
//                if (contact == null) {
//                    contact = new Contact();
//                    contact.setId(id);
//                    contact.setFirstName(rs.getString("first_name"));
//                    contact.setLastName(rs.getString("last_name"));
//                    contact.setBirthDate(rs.getDate("birth_date"));
//                    contact.setContactTelDetails(new ArrayList<ContactTelDetail>());
//                    map.put(id, contact);
//                }
//                Long contactTelDetailId = rs.getLong("contact_tel_id");
//                if (contactTelDetailId > 0) {
//                    ContactTelDetail contactTelDetail = new ContactTelDetail();
//                    contactTelDetail.setId(contactTelDetailId);
//                    contactTelDetail.setContactId(id);
//                    contactTelDetail.setTelType(rs.getString("tel type"));
//                    contactTelDetail.setTelNumber(rs.getString("tel_numЬer"));
//                    contact.getContactTelDetails().add(contactTelDetail);
//                }
//
//            }
//            return new ArrayList<Contact>(map.values());
//        }
//    }
}
