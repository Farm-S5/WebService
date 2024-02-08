package messagerie;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Messagerie {
    String envoyeur;
    String receveur;
    String contenu;
    Timestamp envoi;

    public Messagerie(String envoyeur, String receveur, String contenu, Timestamp envoi) {
        this.envoyeur = envoyeur;
        this.receveur = receveur;
        this.contenu = contenu;
        this.envoi = envoi;
    }

    public Messagerie() {
    }

    public String getEnvoyeur() {
        return envoyeur;
    }

    public void setEnvoyeur(String envoyeur) {
        this.envoyeur = envoyeur;
    }

    public String getReceveur() {
        return receveur;
    }

    public void setReceveur(String receveur) {
        this.receveur = receveur;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Timestamp getEnvoi() {
        return envoi;
    }

    public void setEnvoi(Timestamp envoi) {
        this.envoi = envoi;
    }

    public void insertMessage(MongoDatabase d, Messagerie m) {
        MongoCollection<Document> messagesCollection = d.getCollection("farmgame_message");
        Document messageDocument = new Document()
                .append("envoyeur", m.getEnvoyeur())
                .append("receveur", m.getReceveur())
                .append("contenu", m.getContenu())
                .append("envoi", m.getEnvoi());

        messagesCollection.insertOne(messageDocument);
    }

    public Timestamp getNow() throws Exception
    {
        Instant currentInstant = Instant.now();
        Timestamp t = Timestamp.from(currentInstant);
        return t;
    }

    public Messagerie parseDocument(Document d) throws Exception
    {
        String e = d.getString("envoyeur");
        String r = d.getString("receveur");
        String c = d.getString("contenu");
        Date date = d.getDate("envoi");
        Timestamp t = new Timestamp(date.getTime());

        Messagerie m = new Messagerie(e, r, c, t);
        return m;
    }

    public Messagerie[] findConservationUser(MongoDatabase d,String e,String r) throws Exception
    {
        MongoCollection<Document> messagesCollection = d.getCollection("farmgame_message");
        Document query = new Document("receveur", r)
                .append("envoyeur", e);
        FindIterable<Document> documents = messagesCollection.find(query);
        List<Messagerie> messages = new ArrayList<>();
        for (Document document : documents) {
            Messagerie message = parseDocument(document);
            messages.add(message);
        }

        return messages.toArray(new Messagerie[0]);
    }
}
