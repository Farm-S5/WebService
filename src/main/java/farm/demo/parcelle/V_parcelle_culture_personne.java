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
    double rendementM2Min;
    double rendementM2Max;
    double prixM2;
    double prixM2Min;
    double prixM2Max;
    Time duration;
    int idUser;
    String nomUser;

    public double getRendementM2Min() {
        return rendementM2Min;
    }

    public void setRendementM2Min(double rendementM2Min) {
        this.rendementM2Min = rendementM2Min;
    }

    public double getRendementM2Max() {
        return rendementM2Max;
    }

    public void setRendementM2Max(double rendementM2Max) {
        this.rendementM2Max = rendementM2Max;
    }

    public double getPrixM2Min() {
        return prixM2Min;
    }

    public void setPrixM2Min(double prixM2Min) {
        this.prixM2Min = prixM2Min;
    }

    public double getPrixM2Max() {
        return prixM2Max;
    }

    public void setPrixM2Max(double prixM2Max) {
        this.prixM2Max = prixM2Max;
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

    public V_parcelle_culture_personne(int idParcelle, int idCulture, double rendementM2Min, double rendementM2Max, double prixM2Min, double prixM2Max) {
        this.idParcelle = idParcelle;
        this.idCulture = idCulture;
        this.rendementM2Min = rendementM2Min;
        this.rendementM2Max = rendementM2Max;
        this.prixM2Min = prixM2Min;
        this.prixM2Max = prixM2Max;
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

    public List<V_parcelle_culture_personne> findCulturewithParametre(V_parcelle_culture_personne vp) {
        List<V_parcelle_culture_personne> p = new ArrayList<>();
        try {
            connect.Connect c = new connect.Connect();
            Connection con = c.conekta();
            String sql = "SELECT * FROM v_Parcelle_Culture_Personne WHERE idUser=? AND idCulture=? AND prixM2 BETWEEN ? AND ? AND superficie BETWEEN ? AND ?";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1,vp.getIdUser());
            psd.setInt(2,vp.getIdCulture());
            psd.setDouble(3,vp.getPrixM2Min());
            psd.setDouble(4,vp.getPrixM2Max());
            psd.setDouble(5,vp.getRendementM2Min());
            psd.setDouble(6,vp.getRendementM2Max());
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

    public List<V_parcelle_culture_personne> findCulturewithParametreById(V_parcelle_culture_personne vp) {
        List<V_parcelle_culture_personne> p = new ArrayList<>();
        try {
            connect.Connect c = new connect.Connect();
            Connection con = c.conekta();
            String sql = "SELECT * FROM v_Parcelle_Culture_Personne WHERE idUser=?";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1,vp.getIdUser());
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
