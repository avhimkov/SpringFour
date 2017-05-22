package ch6;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class InsertContactTelDetail extends BatchSqlUpdate{
    public static final String SQL_INSERT_CONTACT_TEL =
            "insert into contact_tel_detail (contact_id, tel_typ, tel_number) values(:contact_id, :tel_typ, :tel_number)";
    public static final int BATCH_SIZE = 10;
    public InsertContactTelDetail(DataSource dataSource){
        super(dataSource, SQL_INSERT_CONTACT_TEL);
        declareParameter(new SqlParameter("contact_id", Types.INTEGER));
        declareParameter(new SqlParameter("tel_type", Types.VARCHAR));
        declareParameter(new SqlParameter("tel_number", Types.VARCHAR));

        setBatchSize(BATCH_SIZE);
    }
}
