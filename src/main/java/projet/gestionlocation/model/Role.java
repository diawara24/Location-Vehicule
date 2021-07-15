package projet.gestionlocation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = {"utilisateurs"})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String libRole;
    private  String libelle;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnoreProperties("roles")
    private List<Utilisateur> utilisateurs;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibRole() {
        return libRole;
    }

    public void setLibRole(String libRole) {
        this.libRole = libRole;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
