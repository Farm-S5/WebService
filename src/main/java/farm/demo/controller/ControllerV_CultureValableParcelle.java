package farm.demo.controller;

import farm.demo.culture.V_CultureValableParcelle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/viewculturevalableparcelle")
public class ControllerV_CultureValableParcelle {
    private final V_CultureValableParcelle vculture;

    public ControllerV_CultureValableParcelle(){
        this.vculture= new V_CultureValableParcelle();
    }

    @GetMapping("/findCultureValableByIdParcelle")
    public List<V_CultureValableParcelle> findCultureValable(@PathVariable int id){
        return vculture.findCultureValableByIdParcelle(id);
    }
}
