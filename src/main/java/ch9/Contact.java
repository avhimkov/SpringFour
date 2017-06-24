package ch9;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "contact")
@NamedQueries({
        @NamedQuery(name = "Contact.findAll", query = "select c from Contact c"),
        @NamedQuery(name = "Contact.countAll", query = "select count (c) from Contact c")})
public class Contact implements Serializable {
    private Long id;
    private int version;
    private String firstName;
    private String lastName;
    private Date birthDate;

    public Contact(){}

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstname() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    @Column(name = "LAST_NAME")
    public String getLastname() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString(){
        return "Contact - Id: " + id + ", First name: " + firstName + ", Last name: " +
                lastName + ", Birthday: " + birthDate;
    }
}
