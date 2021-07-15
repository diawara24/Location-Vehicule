package projet.gestionlocation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class AmmandeVehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double montantAmmande;
    @JsonIgnoreProperties("vehicules")
    @OneToMany(mappedBy ="ammandeVehicule")
    private List<Vehicule> vehicules;

    public AmmandeVehicule() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontantAmmande() {
        return montantAmmande;
    }

    public void setMontantAmmande(double montantAmmande) {
        this.montantAmmande = montantAmmande;
    }

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }
}
