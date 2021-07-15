package projet.gestionlocation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 250)
    private String nom;
    @Column(length = 250)
    private String prenom;
    @Column(length = 250)
    private String adresse;
    @Email
    @Column(length = 250)
    private String email;
    @Column(length = 250)
    private String typeClient;
    @Column(length = 15)
    private String civilite;
    @Column(length = 250)
    private String ville;
    @Column(length = 250)
    private String pays;
    @Column(length = 250)
    private String nomEntreprise;
    @Column(length = 250)
    private double cni;
    @Column(length = 250)
    private int telephone;
    @Column(length = 250)
    private double numPermi;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(length = 250)
    private Date dateNaiss;
    @Column(length = 250)
    private String lieuxNaiss;
    @JsonIgnoreProperties("locations")
    @OneToMany(mappedBy = "client")
    private List<Location> locations;


    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(String typeClient) {
        this.typeClient = typeClient;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public double getCni() {
        return cni;
    }

    public void setCni(int cni) {
        this.cni = cni;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public double getNumPermi() {
        return numPermi;
    }

    public void setNumPermi(int numPermi) {
        this.numPermi = numPermi;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getLieuxNaiss() {
        return lieuxNaiss;
    }

    public void setLieuxNaiss(String lieuxNaiss) {
        this.lieuxNaiss = lieuxNaiss;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
