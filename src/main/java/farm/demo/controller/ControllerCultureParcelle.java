package farm.demo.controller;
import org.springframework.web.bind.annotation.*;
import culture.*;
import java.util.*;
@RestController
@RequestMapping("/cultureparcelle")

public class ControllerCultureParcelle{
    private final CultureParcelle cultureparcelle;

    public ControllerCultureParcelle(){
        this.cultureparcelle=new CultureParcelle();
    }

    @PostMapping("/insertCultureParcelle")
    public void insertCultureParcelle(@RequestBody CultureParcelle cp){
        try{
            cultureparcelle.insertCultureParcelle(cp);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @PostMapping("/insertHistoriqueParcelle")
    public void insertHistoriqueCulture(@RequestBody CultureParcelle cp){
        try{
            cultureparcelle.insertHistoriqueCulture(cp);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}