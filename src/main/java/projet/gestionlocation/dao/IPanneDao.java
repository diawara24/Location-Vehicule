package projet.gestionlocation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.gestionlocation.model.PanneVehicule;

@Repository
public interface IPanneDao extends JpaRepository<PanneVehicule, Integer> {
}
