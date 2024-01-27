package farm.demo.controller;
import org.springframework.web.bind.annotation.*;
import culture.*;
import java.util.*;
@RestController
@RequestMapping("/culture")

public class ControllerCulture
{
    private final Culture culture;

    public ControllerCulture(){
        this.culture=new Culture();
    }

    // {
    //     "nameCulture": "Pomme",
    //     "rendementM2": "75",
    //     "prixM2":"1000",
    //     "duration":"00:05:00"
    // }
    @PostMapping("/insertCulture")
    public void insertCulture(@RequestBody Culture cu){
        try{
            culture.insertCulture(cu);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("/findCulture")
    public List<Culture> findCulture(){
        return culture.findCulture();
    }

    @GetMapping("/findCultureName")
    public List<Culture> findCultureName(){
        return culture.findCultureName();
    }

    @PostMapping("/insertCultureValableParcelle")
    public void insertCultureValableParcelle(@RequestBody Culture cu){
        try{
            culture.insertCultureValableParcelle(cu);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}