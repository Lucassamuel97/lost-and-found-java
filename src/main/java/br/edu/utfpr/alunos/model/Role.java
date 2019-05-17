package br.edu.utfpr.alunos.model;
import javax.persistence.*;

/**
 * Created by ronifabio on 01/05/2019.
 */
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "login", length = 200)
    private String name;

    private String role;

    public Role() {
    }

    public Role(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
