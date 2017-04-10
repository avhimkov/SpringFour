package ch6;

import javax.sql.DataSource;

public class JdbcContactDao implements ContactDao {
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }
}
