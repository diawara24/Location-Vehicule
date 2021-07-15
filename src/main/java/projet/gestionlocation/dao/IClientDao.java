package projet.gestionlocation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.gestionlocation.model.Client;

@Repository
public interface IClientDao extends JpaRepository<Client, Integer> {
}
