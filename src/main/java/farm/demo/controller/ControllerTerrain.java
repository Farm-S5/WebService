package farm.demo.controller;
import org.springframework.web.bind.annotation.*;
import terrain.*;
import java.util.*;
@RestController
@RequestMapping("/terrain")

public class ControllerTerrain{
    private final Terrain terrain;

    public ControllerTerrain(){
        this.terrain=new Terrain();
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/insertTerrain")
    public int insertTerrain(@RequestBody Terrain terrain) {
        try {
            return terrain.insertTerrain(terrain);
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/findTerrain")
    public List<Terrain> findTerrain() throws Exception{
        return terrain.findTerrain();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/getDimensionById/{id}")
    public Terrain getDimension(@PathVariable int id){
        return terrain.getDimension(id);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/findTerrainById/{id}")
    public Terrain findTerrainById(@PathVariable int id){
        return terrain.findTerrainById(id);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/validerTerrain/{id}")
    public void changeEtatTerrain(@PathVariable int id){
        try{
            terrain.changeEtatTerrain(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/findTerrainValider")
    public List<Terrain> findTerrainEtat1(){
        return terrain.findTerrainEtat1();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/findTerrainNonValider")
    public List<Terrain> findTerrainEtat0(){
        return terrain.findTerrainEtat0();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/updateTerrain")
    public void changeTerrain(@RequestBody terrain.Terrain t){
        try {
            terrain.changeDetailTerrain(t);
        }catch (Exception ex){
            ex.getStackTrace();
        }
    }
}