package farm.demo.controller;
import org.springframework.web.bind.annotation.*;
import terrain.*;
import java.util.*;
@RestController
@RequestMapping("/historiqueterrain")

public class ControllerHistoriqueTerrain{
    private final HistoriqueTerrain historiqueterrain;

    public ControllerHistoriqueTerrain(){
        this.historiqueterrain = new HistoriqueTerrain();
    }

    @PostMapping("/insertHistoriqueTerrain")
    public void insertHistoriqueTerrain(@RequestBody HistoriqueTerrain ht){
        try{
            historiqueterrain.insertHistoriqueTerrain(ht);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}