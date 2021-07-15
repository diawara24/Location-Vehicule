package projet.gestionlocation.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projet.gestionlocation.model.Client;

import java.util.List;

public interface IClientService {
    public Page<Client> findAll(Pageable pageable);
    public Client saave(Client client);
    public void delete(Client client);
}
