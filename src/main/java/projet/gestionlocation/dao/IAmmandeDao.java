package projet.gestionlocation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.gestionlocation.model.AmmandeVehicule;

@Repository
public interface IAmmandeDao extends JpaRepository<AmmandeVehicule, Integer> {
}
