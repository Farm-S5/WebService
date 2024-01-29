package farm.demo.controller;
import org.springframework.web.bind.annotation.*;
import parcelle.*;
import java.util.*;
@RestController
@RequestMapping("/parcelle")

public class ControllerParcelle{
    private final Parcelle parcelle;

    public ControllerParcelle(){
        this.parcelle = new Parcelle();
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/insertParcelle")
    public void insertParcelle(@RequestBody Parcelle p){
        try{
            parcelle.insertParcelle(p);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/findParcelle")
    public List<Parcelle> findParcelle(){
        return parcelle.findParcelle();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/findParcelleByIdParcelle/{id}")
    public Parcelle findParcelleByIdParcelle(@PathVariable int id){
        return parcelle.findParcelleByIdParcelle(id);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/findParcelleByIdTerrain/{id}")
    public List<Parcelle> findParcelleByIdTerrain(@PathVariable int id){
        return parcelle.findParcelleByIdTerrain(id);
    }
}