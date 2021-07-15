package projet.gestionlocation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.gestionlocation.model.MarqueVehicule;

@Repository
public interface IMarqueDao extends JpaRepository<MarqueVehicule, Integer> {
}
