package spring.people.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;


@Component
@Entity
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer _id;
    private String lastname;
    private String firstname;
    private String address;


    protected People(){
        lastname = "default";
        _id = -1;
        firstname = "default";
        address = "default";
    }

    public People(int _id, String lastname, String firstname, String address) {
        this._id = _id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
