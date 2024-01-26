package farm.demo.controller;
import org.springframework.web.bind.annotation.*;
import terrain.*;
import java.util.*;
@RestController
@RequestMapping("/phototerrain")

public class ControllerPhotoTerrain{
    private final PhotoTerrain phototerrain;

    public ControllerPhotoTerrain(){
        this.phototerrain = new PhotoTerrain();
    }

    @PostMapping("/insertPhotoTerrain")
    public void insertPhotoTerrain(@RequestBody Map<String, Object> requestBody ){
        try{
            phototerrain.insertPhotoTerrain(requestBody);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}