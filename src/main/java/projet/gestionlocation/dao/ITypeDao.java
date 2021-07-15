package projet.gestionlocation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.gestionlocation.model.TypeVehicule;

@Repository
public interface ITypeDao extends JpaRepository<TypeVehicule, Integer> {
}
