package farm.demo.parcelle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class V_parcelle_culture_personne {
    int idParcelle;
    double rendement;
    double superficie;
    int idCulture;
    String nomCulture;
    double rendementM2;
    double prixM2;
    Time duration;
    int idUser;
    String nomUser;

    public V_parcelle_culture_personne() {
    }

    public V_parcelle_culture_personne(int idParcelle, double rendement, double superficie, int idCulture, String nomCulture, double rendementM2, double prixM2, Time duration, int idUser, String nomUser) {
        this.idParcelle = idParcelle;
        this.rendement = rendement;
        this.superficie = superficie;
        this.idCulture = idCulture;
        this.nomCulture = nomCulture;
        this.rendementM2 = rendementM2;
        this.prixM2 = prixM2;
        this.duration = duration;
        this.idUser = idUser;
        this.nomUser = nomUser;
    }

    public int getIdParcelle() {
        return idParcelle;
    }

    public void setIdParcelle(int idParcelle) {
        this.idParcelle = idParcelle;
    }

    public double getRendement() {
        return rendement;
    }

    public void setRendement(double rendement) {
        this.rendement = rendement;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public int getIdCulture() {
        return idCulture;
    }

    public void setIdCulture(int idCulture) {
        this.idCulture = idCulture;
    }

    public String getNomCulture() {
        return nomCulture;
    }

    public void setNomCulture(String nomCulture) {
        this.nomCulture = nomCulture;
    }

    public double getRendementM2() {
        return rendementM2;
    }

    public void setRendementM2(double rendementM2) {
        this.rendementM2 = rendementM2;
    }

    public double getPrixM2() {
        return prixM2;
    }

    public void setPrixM2(double prixM2) {
        this.prixM2 = prixM2;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public List<V_parcelle_culture_personne> findCulture() {
        List<V_parcelle_culture_personne> p = new ArrayList<>();
        try {
            connect.Connect c = new connect.Connect();
            Connection con = c.conekta();
            String sql = "Select * from V_parcelle_culture_personne";
            PreparedStatement psd = con.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            while (rs.next()) {
                p.add(new V_parcelle_culture_personne(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),rs.getDouble(6),rs.getDouble(7),rs.getTime(8),rs.getInt(9),rs.getString(10)));
            }
            psd.close();
            con.close();
            return p;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }
}
