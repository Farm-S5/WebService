package farm.demo;
import org.springframework.web.bind.annotation.*;
import culture.*;
import java.util.*;
@RestController
@RequestMapping("/cultures")
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
    @PostMapping("/insert")
    public void insertCulture(@RequestBody Culture cu){
        try{
            culture.insertCulture(cu);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("/find")
    public List<Culture> findCulture(){
        return culture.findCulture();
    }

    @GetMapping("/findName")
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