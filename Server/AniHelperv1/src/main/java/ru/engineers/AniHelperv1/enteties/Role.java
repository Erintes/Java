package ru.engineers.AniHelperv1.enteties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
    @Id
    private int Id;

    public int getId(){
        return this.Id;
    }

    @Column(name="name")
    private String role;

    public String getRole(){
        return this.role;
    }
}
