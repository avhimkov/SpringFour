package ch8;

import org.springframework.data.domain.Persistable;
import org.joda.time.DateTime;
import java.io.Serializable;

public interface Auditable <U, ID extends Serializable> extends Persistable<ID>{
    U getCreatedBy();
    void setCreateBy(final  U createBy);
    DateTime getCreatedData();
    void setCreatedDate(final DateTime creationDate);
    U getLastModifiedBy();
    void setLastModifiedBy(final U lastModifiedBy);
    DateTime getLastModifiedDate();
    void setLastModifiedDate(final DateTime lastModifiedDate);
}
