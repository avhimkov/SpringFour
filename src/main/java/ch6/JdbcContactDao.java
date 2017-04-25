package ch6;

import org.springframework.beans.factory.BeanCreationException;

import javax.sql.DataSource;

public class JdbcContactDao implements ContactDao {
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void afterPropertiesSet() throws Exception{
        if (dataSource==null){
            throw new BeanCreationException("Must set dataSource on ContactDao");
        }
    }
}
