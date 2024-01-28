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

    @PostMapping("/insertTerrain")
    public void insertTerrain(@RequestBody Terrain terrain){
        try{
            terrain.insertTerrain(terrain);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @GetMapping("/findTerrain")
    public List<Terrain> findTerrain() throws Exception{
        return terrain.findTerrain();
    }

    @GetMapping("/getDimensionById/{id}")
    public Terrain getDimension(@PathVariable int id){
        return terrain.getDimension(id);
    }

    @GetMapping("/findTerrainById/{id}")
    public Terrain findTerrainById(@PathVariable int id){
        return terrain.findTerrainById(id);
    }

    @PostMapping("/validerTerrain/{id}")
    public void changeEtatTerrain(@PathVariable int id){
        try{
            terrain.changeEtatTerrain(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @GetMapping("/findTerrainValider")
    public List<Terrain> findTerrainEtat1(){
        return terrain.findTerrainEtat1();
    }
}