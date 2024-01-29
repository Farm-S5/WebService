package farm.demo.controller;
import org.springframework.web.bind.annotation.*;
import personne.*;
import java.util.*;
@RestController
@RequestMapping("/personne")
public class ControllerPersonne {

    private final Personne personne;

    public ControllerPersonne() {
        this.personne = new Personne();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/findPersonneById/{id}")
    public Personne getPersonneById(@PathVariable int id) {
        return personne.findPersonneById(id);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/findPersonne")
    public List<Personne> getAllPersonnes() {
        return personne.findPersonne();
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/insertPersonne")
    public void insertPersonne(@RequestBody Personne p) {
        try {
            personne.insertPersonne(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/checkPersonne")
    public int checkPersonne(@RequestBody Personne p) {
        try {
            return personne.checkPersonne(p);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
