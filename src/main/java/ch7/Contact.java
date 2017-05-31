package ch7;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "contact")
public class Contact implements Serializable{
    private Long id;
    private int version;
    private String firstname;
    private String lastname;
    private Date birthDate;
    private Set<ContactTelDetail> contactTelDetails = new HashSet<ContactTelDetail>();
    private Set<Hobby> hobbies = new HashSet<Hobby>();


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
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "LAST_NAME")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ContactTelDetail> getContactTelDetails() {
        return this.contactTelDetails;
    }

    public void setContactTelDetails(Set<ContactTelDetail> contactTelDetails) {
        this.contactTelDetails = contactTelDetails;
    }

    public void removeContactTelDetail(ContactTelDetail contactTelDetail){
        getContactTelDetails().remove(contactTelDetail);
    }

    public void addContactTelDetail(ContactTelDetail contactTelDetail){
        contactTelDetail.setContact(this);
        getContactTelDetails().add(contactTelDetail);
    }

    @ManyToMany
    @JoinTable(name = "contact_hobby_detail", joinColumns = @JoinColumn(name = "HOBBY_ID"))
    public Set<Hobby> getHobbies(){
        return this.hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies){
        this.hobbies = hobbies;
    }

    public String toString(){
        return "Contact - Id: " + id + ", First name: " + firstname + ", Last name: " +
                lastname + ", Birthday: " + birthDate;
    }
}