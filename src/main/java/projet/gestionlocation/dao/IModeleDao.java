package projet.gestionlocation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projet.gestionlocation.model.MarqueVehicule;
import projet.gestionlocation.model.ModeleVehicule;

import java.util.List;

@Repository
public interface IModeleDao extends JpaRepository<ModeleVehicule, Integer> {
    @Query("select m from ModeleVehicule m where m.marqueVehicule.id =: id order by m.nomModele asc ")
    public List<ModeleVehicule> findByMarqueVehicule(@Param("id") int id);
}
