package farm.demo.controller;
import org.springframework.web.bind.annotation.*;
import terrain.*;
import java.util.*;
@RestController
@RequestMapping("/terrainpersonne")
public class ControllerTerrainPersonne{
    private final TerrainPersonne terrainpersonne;
    
    public ControllerTerrainPersonne(){
        this.terrainpersonne = new TerrainPersonne();
    }

    @PostMapping("/insertTerrainPersonne")
    public void insertTerrainPersonne(@RequestBody TerrainPersonne p){
        try{
            terrainpersonne.insertTerrainPersonne(p);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}