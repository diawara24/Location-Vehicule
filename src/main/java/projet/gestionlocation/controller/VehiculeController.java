package projet.gestionlocation.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projet.gestionlocation.dao.*;
import projet.gestionlocation.model.ModeleVehicule;
import projet.gestionlocation.model.Vehicule;
import projet.gestionlocation.service.IModeleService;
import projet.gestionlocation.service.IVehiculeService;

import java.util.List;


@Controller
public class VehiculeController {
    @Autowired
    private IModeleService modeleService;
    @Autowired
    private ITarifDao tarifDao;
    @Autowired
    private IAmmandeDao ammandeDao;
    @Autowired
    private IVehiculeService vehiculeService;
    @Autowired
    private IMarqueDao marqueDao;
    @Autowired
    private ITypeDao typeDao;

    @GetMapping("/listeVehicule")
    public String liste(Model model, @RequestParam(name = "page", defaultValue = "0") int p){
        Pageable pageable = PageRequest.of(p,5);
        Page<Vehicule> vh = vehiculeService.findAll(pageable);
        int nb = vh.getTotalPages();
        int[] pages = new int[nb];
        for (int i = 0; i < nb; i++) {
            pages[i] = i;
        }
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", p);
        model.addAttribute("veh",vh);
        return "vehicule";
    }
    @GetMapping("/addVehicule")
    public String add(Model model){
        model.addAttribute("veh", new Vehicule());
        model.addAttribute("typeV",typeDao.findAll());
        model.addAttribute("marque",marqueDao.findAll());
        model.addAttribute("modele",modeleService.findAll());
        model.addAttribute("tarif",tarifDao.findAll());
        model.addAttribute("ammande",ammandeDao.findAll());
        return "ajoutVehicule";
    }
    @PostMapping("/addVehicule")
    public String add(@ModelAttribute("veh") Vehicule v, Model model){
        vehiculeService.save(v);
        return "redirect:/listeVehicule";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public  String loadModeleByMarque(@PathVariable(name = "marque") int id){
       Gson gson = new Gson();
       return gson.toJson(modeleService.findByMarqueVehicule(id));
    }

}
