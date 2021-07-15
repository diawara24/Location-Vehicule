package projet.gestionlocation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class MarqueVehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 200)
    private String nomMarque;
    @JsonIgnoreProperties("modeleVehicules")
    @OneToMany(mappedBy = "marqueVehicule")
    private List<ModeleVehicule> modeleVehicules;

    public MarqueVehicule() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public List<ModeleVehicule> getModeleVehicules() {
        return modeleVehicules;
    }

    public void setModeleVehicules(List<ModeleVehicule> modeleVehicules) {
        this.modeleVehicules = modeleVehicules;
    }
}
