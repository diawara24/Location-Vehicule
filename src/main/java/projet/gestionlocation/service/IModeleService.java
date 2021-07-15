package projet.gestionlocation.service;

import projet.gestionlocation.model.ModeleVehicule;

import java.util.List;

public interface IModeleService {
    public List<ModeleVehicule> findAll();
    public List<ModeleVehicule> findByMarqueVehicule(int id);
}
