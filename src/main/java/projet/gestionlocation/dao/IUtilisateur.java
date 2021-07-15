package projet.gestionlocation.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.gestionlocation.model.Utilisateur;

import java.util.Optional;

@Repository
public interface IUtilisateur extends JpaRepository<Utilisateur, Integer> {
    public Utilisateur findByLogin(String login);
    public Utilisateur findByEmail(String email);
    public Utilisateur save(Utilisateur utilisateur);
    public void delete(Utilisateur utilisateur);
    public Utilisateur findById(int id);
}
