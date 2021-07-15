package projet.gestionlocation.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import projet.gestionlocation.dao.IRole;
import projet.gestionlocation.dao.IUtilisateur;
import projet.gestionlocation.model.Client;
import projet.gestionlocation.model.Role;
import projet.gestionlocation.model.Utilisateur;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class DefaultController {
    @Value("${imageLoc}")
    private String mesimages;
    @Autowired
    private IRole role;
    @Autowired
    private IUtilisateur utilisateur;
    @Autowired
    BCryptPasswordEncoder encoder;
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/403")
    public String error403(){
        return "403";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String add(Model model ){
        model.addAttribute("user", new Utilisateur());
        model.addAttribute("role",role.findAll());
        return "utilisateur";
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/liste")
    public String liste(Model model ,@RequestParam(name = "page", defaultValue="0")  int p){
        Pageable pageable = PageRequest.of(p,5);
        Page<Utilisateur> u = utilisateur.findAll(pageable);
        int nbPage = u.getTotalPages();
        int[] pages = new int[nbPage];
        for (int i = 0; i < nbPage ; i++) {
            pages[i]= i;
        }
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", p);
        model.addAttribute("users", u);
        return "listeUtilisateur";
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/admin")
    public String add(@ModelAttribute("user") Utilisateur u, @RequestParam("roles") int roleId,
                      @RequestParam("image")MultipartFile file,
                      Model model) throws Exception {

       Optional<Role>  r =  role.findById(roleId);
       Role role = null;
       if (r.isPresent()){
           role = r.get();
       }
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        u.setRoles(roles);
        u.setPwd(encoder.encode(u.getPwd()));

        if (!(file.isEmpty())) {
            u.setPhoto(file.getOriginalFilename());
            utilisateur.save(u);
        }

        //recuperation de photo
        if (!(file.isEmpty())) {
            u.setPhoto(file.getOriginalFilename());
            file.transferTo(new File(mesimages+u.getId()));
        }
        utilisateur.save(u);
        System.out.println("ok ");
        return "redirect:/liste";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("role",role.findAll());
        model.addAttribute("user", utilisateur.findById(id));

        return "utilisateur";
    }
    //recuperer la photo stocker dans le dossier sur lordinateur
    @GetMapping(value = "/getPhoto",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getphoto(int id) throws Exception {
        File f = new File(mesimages+id);
        return IOUtils.toByteArray(new FileInputStream(f));

    }
    //Supprimer un utilisateur
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model){
        utilisateur.delete(utilisateur.findById(id));
        return "redirect:/liste";
    }
}
