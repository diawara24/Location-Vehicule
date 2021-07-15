package projet.gestionlocation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projet.gestionlocation.dao.IModeleDao;
import projet.gestionlocation.dao.IVehiculeDao;
import projet.gestionlocation.model.ModeleVehicule;
import projet.gestionlocation.model.Vehicule;

import java.util.List;

@Service
public class VehiculeService implements IVehiculeService {
    @Autowired
    private IVehiculeDao vehiculeDao;

    @Override
    public Page<Vehicule> findAll(Pageable pageable) {
        return vehiculeDao.findAll(pageable);
    }

    @Override
    public Vehicule save(Vehicule vehicule) {
        return vehiculeDao.save(vehicule);
    }

    @Override
    public void delete(Vehicule vehicule) {
        vehiculeDao.delete(vehicule);
    }


}
