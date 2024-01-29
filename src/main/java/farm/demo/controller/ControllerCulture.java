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
    @CrossOrigin(origins = "*")
    @PostMapping("/insertCulture")
    public void insertCulture(@RequestBody Culture cu){
        try{
            culture.insertCulture(cu);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/findCulture")
    public List<Culture> findCulture(){
        return culture.findCulture();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/findCultureName")
    public List<Culture> findCultureName(){
        return culture.findCultureName();
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/insertCultureValableParcelle")
    public void insertCultureValableParcelle(@RequestBody Culture cu){
        try{
            culture.insertCultureValableParcelle(cu);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}