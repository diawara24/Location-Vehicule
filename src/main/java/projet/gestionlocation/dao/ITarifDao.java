package projet.gestionlocation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.gestionlocation.model.TarifLoction;

@Repository
public interface ITarifDao extends JpaRepository<TarifLoction, Integer> {
}
