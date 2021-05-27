package ru.engineers.AniHelperv1.enteties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorroles")
public class AuthorRole {
    @Id
    private int Id;

    @Column(name="authorid")
    private int authorid;

    @Column(name="roleid")
    public int roleid;
}
