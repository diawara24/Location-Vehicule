package projet.gestionlocation.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import projet.gestionlocation.model.ModeleVehicule;
import projet.gestionlocation.model.Vehicule;

import java.util.List;

public interface IVehiculeService {
    public Page<Vehicule> findAll(Pageable pageable);
    public Vehicule save(Vehicule vehicule);
    public void delete(Vehicule vehicule);
}
