package ch7;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class Hobby implements Serializable{
    private String hobbyId;

    @Id
    @Column(name = "HOBBY_ID")
    public String getHobbyId() {
        return this.hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    public String toString(){
        return "Hobby :" + getHobbyId();
    }
}
