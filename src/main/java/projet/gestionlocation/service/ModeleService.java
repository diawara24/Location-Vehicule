package projet.gestionlocation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.gestionlocation.dao.IModeleDao;
import projet.gestionlocation.model.ModeleVehicule;

import java.util.List;

@Service
public class ModeleService implements IModeleService{
    @Autowired
    private IModeleDao modeleDao;

    @Override
    public List<ModeleVehicule> findAll() {
        return modeleDao.findAll();
    }

    @Override
    public List<ModeleVehicule> findByMarqueVehicule(int id) {
        return modeleDao.findByMarqueVehicule(id);
    }
}
