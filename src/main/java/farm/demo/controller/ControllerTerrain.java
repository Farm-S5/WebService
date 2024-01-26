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

    @GetMapping("/find")
    public List<Terrain> findTerrain() throws Exception{
        return terrain.findTerrain();
    }

    @GetMapping("/getDimension{id}")
    public Terrain getDimension(int id){
        return terrain.getDimension(id);
    }

    @GetMapping("/findTerrainById{id}")
    public Terrain findTerrainById(int id){
        return terrain.findTerrainById(id);
    }
}