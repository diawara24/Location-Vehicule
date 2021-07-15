package projet.gestionlocation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class ModeleVehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100)
    private String nomModele;
    @JsonIgnoreProperties("vehicules")
    @OneToMany(mappedBy = "modeleVehicule")
    private List<Vehicule> vehicules;
    @JsonIgnoreProperties("modeleVehicules")
    @ManyToOne
    @JoinColumn(name = "marque_id")
    private MarqueVehicule marqueVehicule;



    public ModeleVehicule() {
        marqueVehicule = new MarqueVehicule();
    }

    public ModeleVehicule(int id, String nomModele) {
        this.id = id;
        this.nomModele= nomModele;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MarqueVehicule getMarqueVehicule() {
        return marqueVehicule;
    }

    public void setMarqueVehicule(MarqueVehicule marqueVehicule) {
        this.marqueVehicule = marqueVehicule;
    }

    public String getNomModele() {
        return nomModele;
    }

    public void setNomModele(String nomModele) {
        this.nomModele = nomModele;
    }

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }
}
