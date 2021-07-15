package projet.gestionlocation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.gestionlocation.model.Vehicule;

@Repository
public interface IVehiculeDao extends JpaRepository<Vehicule, Integer> {

}

