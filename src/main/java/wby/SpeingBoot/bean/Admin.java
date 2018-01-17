package wby.SpeingBoot.bean;

import javax.persistence.*;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    @Column(unique = true, nullable = false)
    String name;
    @Column(nullable = false)
    String passow;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassow() {
        return passow;
    }

    public void setPassow(String passow) {
        this.passow = passow;
    }

    public Admin(){}

    public Admin(String name, String passow) {
        this.name = name;
        this.passow = passow;
    }
}
