package ch8;

import static javax.persistence.GenerationType.IDENTITY;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contact_audit")
public class ContactAudit implements Auditable<String, Long>, Serializable{
    private Long id;
    private int version;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String createdBy;
    private DateTime createdDate;
    private String lastModifiedBy;
    private DateTime lastModifiedDate;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion(){
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setCreateBy(String createBy) {
        this.createdBy = createBy;
    }

    @Column(name = "CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }

    @Column(name = "CREATED_DATE")
    @Type(type = "org.jadira.isertype.dateandtime.joda.PersistentDateTime")
    public DateTime getCreatedData() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "LAST_MODIFIED_BY")
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;

    }

    @Column(name = "LAST_MODIFIED_DATE")
    @Type(type = "org.jadira.isertype.dateandtime.joda.PersistentDateTime")
    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean isNew() {
        if (id == null){
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return "Contact - Id: " + id + ", First name: " + firstName + " Last name: "
                + lastName + ", Birthday: " + birthDate + ", Create bу: " + createdBy + ", Create date: " + createdDate
                + ", Modified bу: " + lastModifiedBy + ", Modified date: " + lastModifiedDate;
    }
}
