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

    @PostMapping("/insertParcelle")
    public void insertParcelle(@RequestBody Parcelle p){
        try{
            parcelle.insertParcelle(p);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @GetMapping("/findParcelle")
    public List<Parcelle> findParcelle(){
        return parcelle.findParcelle();
    }
}