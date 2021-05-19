package ru.engineers.AniHelperv1.enteties;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String login;

    @Column
    private Integer password;

    public Users(){};

    public Users(String login, Integer password){
        this.login = login;
        this.password = password;
    }

    public Integer getPassword(){
        return password;
    }
}
