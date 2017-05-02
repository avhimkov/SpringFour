package ch6;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcContactDao implements ContactDao, InitializingBean {
    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public String findFirstNameById(Long id){
        String sql = "select last_name from contact where id = :contactId";
        Map<String, Object> nameParametrs = new HashMap<String, Object>();
        nameParametrs.put("contactId", id);

        return namedParameterJdbcTemplate.queryForObject(sql, nameParametrs, String.class);
    }

    @Override
    public List<Contact> findAll(){
        String sql = "select id, first_name, last_name, birh_data from contact";
        return namedParameterJdbcTemplate.query(sql, new ContactMapper());
    }

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void afterPropertiesSet() throws Exception{
        if (dataSource==null){
            throw new BeanCreationException("Must set dataSource on ContactDao");
        }
        if (namedParameterJdbcTemplate==null){
            throw new BeanCreationException("Null namedParameterJdbcTemplate on ContactDao");
        }
    }

    public static final class ContactMapper implements RowMapper<Contact> {
        @Override
        public Contact mapRow(ResultSet rs, int rowNumm) throws SQLException {
            Contact contact = new Contact();
            contact.setId(rs.getLong("id"));
            contact.setFirstName(rs.getString("first_name"));
            contact.setLastName(rs.getString("last_name"));
            contact.setBirthDate(rs.getDate("birth_name"));

            return contact;
        }
    }
}
