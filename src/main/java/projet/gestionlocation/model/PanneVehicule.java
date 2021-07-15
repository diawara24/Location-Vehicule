package projet.gestionlocation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PanneVehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    private String libellePanne;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datePanne;
    @JsonIgnoreProperties("panneVehicules")
    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    public PanneVehicule() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibellePanne() {
        return libellePanne;
    }

    public void setLibellePanne(String libellePanne) {
        this.libellePanne = libellePanne;
    }

    public Date getDatePanne() {
        return datePanne;
    }

    public void setDatePanne(Date datePanne) {
        this.datePanne = datePanne;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
}
