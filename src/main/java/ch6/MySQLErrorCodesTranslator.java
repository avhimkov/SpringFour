package ch6;

import java.sql.SQLException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.dao.DataAccessException;


public class MySQLErrorCodesTranslator extends SQLErrorCodeSQLExceptionTranslator {

    @Override
    protected DataAccessException costomTranslate(String task, String sql, SQLException sqlx){
        if (sqlx.getErrorCode()==-12345){
            return new DeadlockLoserDataAccessException(task, sqlx);
        }
        return null;
    }
}
