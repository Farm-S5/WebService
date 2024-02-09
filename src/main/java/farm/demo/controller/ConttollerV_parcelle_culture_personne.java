package farm.demo.controller;

import farm.demo.parcelle.V_parcelle_culture_personne;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parcellecultureparcelle")
public class ConttollerV_parcelle_culture_personne {
    private final V_parcelle_culture_personne culture;

    public ConttollerV_parcelle_culture_personne() {
        this.culture=new V_parcelle_culture_personne();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/findParcelleCulturePersonne")
    public List<V_parcelle_culture_personne> findCulture(){
        return culture.findCulture();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/findParcelleCulturePersonneWithParameters")
    public List<V_parcelle_culture_personne> findCultureWithParameters(@RequestBody V_parcelle_culture_personne cu){
        return culture.findCulturewithParametre(cu);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/findParcelleCulturePersonneWithParametersById")
    public List<V_parcelle_culture_personne> findCultureWithParametersById(@RequestBody V_parcelle_culture_personne cu){
        return culture.findCulturewithParametre(cu);
    }
}
