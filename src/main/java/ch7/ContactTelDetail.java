package ch7;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;

@Entity
@Table(name = "contact_tel_detail")
public class ContactTelDetail implements Serializable{
    private Long id;
    private int version;
    private String telType;
    private String telNumber;

    public ContactTelDetail(){}

    public ContactTelDetail(String telType, String telNumber){
        this.telType = telType;
        this.telNumber = telNumber;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId(){
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
    public void setVersion(int version){
        this.version = version;
    }

    @Column(name = "TEL_TYPE")
    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    @Column(name = "TEL_NUMBER")
    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}
