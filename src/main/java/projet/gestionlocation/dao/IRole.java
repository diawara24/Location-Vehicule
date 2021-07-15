package projet.gestionlocation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projet.gestionlocation.model.Role;

@Repository
public interface IRole extends JpaRepository<Role, Integer> {
    
}
