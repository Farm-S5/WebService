package farm.demo.controller;

import farm.demo.terrain.V_HistoriqueTerrainPersonne;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viewhistoriqueterrainpersonne")
public class ControllerV_HistoriqueTerrainPersonne {
    private final V_HistoriqueTerrainPersonne vhistopersonne;

    public ControllerV_HistoriqueTerrainPersonne(){
        this.vhistopersonne = new V_HistoriqueTerrainPersonne();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/findHistoriqueTerrainPersonne")
    public List<V_HistoriqueTerrainPersonne> findHistoriqueTerrainPersonne(){
        return vhistopersonne.findHistoriqueTerrain();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/findHitoriqueTerrainPersonneByAcheteur/{id}")
    public List<V_HistoriqueTerrainPersonne> findHistoriqueTerrainPersonneByAcheteur(@PathVariable int id){
        return vhistopersonne.findHistoriqueTerrainByIdAcheteur(id);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/findHistoriqueTerrainPersonneByVendeur/{id}")
    public List<V_HistoriqueTerrainPersonne> finidHistoriqueTerrainPersonneByVendeur(@PathVariable int id){
        return vhistopersonne.findHistoriqueTerrainByIdAcheteur(id);
    }
}
