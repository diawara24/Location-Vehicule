package projet.gestionlocation.controller;


import org.hibernate.sql.ordering.antlr.SortKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projet.gestionlocation.model.Client;
import projet.gestionlocation.service.IClientService;

import java.util.List;


@Controller
public class ClientController {
    @Autowired
    private IClientService clientService;
    @GetMapping("/addClient")
    public String add(Model model,@RequestParam(name = "page", defaultValue="0")  int p){
        Pageable pageable = PageRequest.of(p,10);
        Page<Client> cl = clientService.findAll(pageable);
        int nbPage = cl.getTotalPages();
        int[] pages = new int[nbPage];
        for (int i = 0; i < nbPage ; i++) {
            pages[i]= i;
        }
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", p);
        model.addAttribute("clients", cl);
        return "clients";
    }
}
