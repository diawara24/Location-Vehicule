package projet.gestionlocation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20)
    private String matricule;
    @Column(length = 30)
    private String coleur;
    @Column(length = 100)
    private String categorie;
    @Column(length = 200)
    private String carburant;
    private double prixAchat;
    private boolean status;
    @JsonIgnoreProperties("vehicules")
    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeVehicule typeVehicule;
    @ManyToOne
    @JoinColumn(name = "modele_id")
    private ModeleVehicule modeleVehicule;
    @ManyToOne
    @JoinColumn(name = "ammande_id")
    private AmmandeVehicule ammandeVehicule;
    @ManyToOne
    @JoinColumn(name = "tarif_id")
    private TarifLoction tarifLoction;
    @JsonIgnoreProperties("panneVehicules")
    @OneToMany(mappedBy = "vehicule")
    private List<PanneVehicule> panneVehicules;

    public Vehicule() {
        typeVehicule = new TypeVehicule();
        modeleVehicule = new ModeleVehicule();
        ammandeVehicule = new AmmandeVehicule();
        tarifLoction = new TarifLoction();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getColeur() {
        return coleur;
    }

    public void setColeur(String coleur) {
        this.coleur = coleur;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public TypeVehicule getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(TypeVehicule typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public ModeleVehicule getModeleVehicule() {
        return modeleVehicule;
    }

    public void setModeleVehicule(ModeleVehicule modeleVehicule) {
        this.modeleVehicule = modeleVehicule;
    }

    public AmmandeVehicule getAmmandeVehicule() {
        return ammandeVehicule;
    }

    public void setAmmandeVehicule(AmmandeVehicule ammandeVehicule) {
        this.ammandeVehicule = ammandeVehicule;
    }

    public TarifLoction getTarifLoction() {
        return tarifLoction;
    }

    public void setTarifLoction(TarifLoction tarifLoction) {
        this.tarifLoction = tarifLoction;
    }

    public List<PanneVehicule> getPanneVehicules() {
        return panneVehicules;
    }

    public void setPanneVehicules(List<PanneVehicule> panneVehicules) {
        this.panneVehicules = panneVehicules;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
