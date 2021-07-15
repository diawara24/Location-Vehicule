package projet.gestionlocation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.gestionlocation.dao.IClientDao;
import projet.gestionlocation.model.Client;

@Service
public class ClientService implements IClientService {
    @Autowired
    private IClientDao clientDao;


    @Override
    public Page<Client> findAll(Pageable pageable) {
        return clientDao.findAll(pageable);
    }

    @Override
    public Client saave(Client client) {
        return clientDao.save(client);
    }

    @Override
    public void delete(Client client) {
        clientDao.delete(client);
    }
}
