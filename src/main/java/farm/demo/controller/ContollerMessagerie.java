package farm.demo.controller;
import messagerie.*;
import com.mongodb.client.MongoDatabase;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/messagerie")
public class ContollerMessagerie {

    @CrossOrigin(origins = "*")
    @PostMapping("/insertmessage")
    public String insertMessage(@RequestParam String envoyeur, @RequestParam String receveur, @RequestParam String contenu)
    {
        try{
            connect.Connect con = new connect.Connect();
            MongoDatabase c = con.conektaMongo();
            messagerie.Messagerie m = new Messagerie();
            Timestamp t = m.getNow();
            Messagerie nM = new Messagerie(envoyeur,receveur,contenu,t);
            m.insertMessage(c,nM);
            return "{ \"success\": \"Insertion réussie\" }";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "{ \"error\": \"Oups... Quelque chose s'est mal passé\" }";
        }
    }
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/getMessageEnvoye", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMessageEnvoye(@RequestParam String envoyeur, @RequestParam String receveur)
    {
        try{
            connect.Connect con = new connect.Connect();
            MongoDatabase c = con.conektaMongo();
            Messagerie m = new Messagerie();
            Messagerie[] allMessage = m.findConservationUser(c,envoyeur,receveur);
            JSONArray jsonArray = new JSONArray();
            for (Messagerie message : allMessage) {
                JSONObject messageJson = new JSONObject();
                messageJson.put("envoyeur", message.getEnvoyeur());
                messageJson.put("receveur", message.getReceveur());
                messageJson.put("contenu", message.getContenu());
                messageJson.put("envoi", message.getEnvoi());
                jsonArray.put(messageJson);
            }
            return jsonArray.toString();
        }

        catch (Exception e) {
            e.printStackTrace();
            return "{ \"error\": \"Oups... Quelque chose s'est mal passé\" }";
        }
    }
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/getMessageRecuByPersonne", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMessageRecu( @RequestParam String receveur)
    {
        try{
            connect.Connect con = new connect.Connect();
            MongoDatabase c = con.conektaMongo();
            Messagerie m = new Messagerie();
            Messagerie[] allMessage = m.findConservationPersonne(c,receveur);
            JSONArray jsonArray = new JSONArray();
            for (Messagerie message : allMessage) {
                JSONObject messageJson = new JSONObject();
                messageJson.put("envoyeur", message.getEnvoyeur());
                messageJson.put("receveur", message.getReceveur());
                messageJson.put("contenu", message.getContenu());
                messageJson.put("envoi", message.getEnvoi());
                jsonArray.put(messageJson);
            }
            return jsonArray.toString();
        }

        catch (Exception e) {
            e.printStackTrace();
            return "{ \"error\": \"Oups... Quelque chose s'est mal passé\" }";
        }
    }
}
