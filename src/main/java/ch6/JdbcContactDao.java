package ch6;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
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
}
