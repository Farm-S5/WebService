package farm.demo.controller;
import farm.demo.terrain.V_TerrainPersonne;
import org.springframework.web.bind.annotation.*;
import terrain.*;
import java.util.*;
@RestController
@RequestMapping("/viewterrainpersonne")
public class ControllerV_TerrainPersonne {
    private final V_TerrainPersonne viewTerrainPersonne;

    public ControllerV_TerrainPersonne(){
        this.viewTerrainPersonne =new V_TerrainPersonne();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/findTerrainPersonneNonValider/{id}")
    public List<V_TerrainPersonne> findTerrainPersonneNonValider(@PathVariable int id){
        return viewTerrainPersonne.findTerrainPersonneNonValider(id);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/findTerrainPersonneValider/{id}")
    public List<V_TerrainPersonne> findTerrainPersonneValider(@PathVariable int id){
        return viewTerrainPersonne.findTerrainPersonneValider(id);
    }
}
