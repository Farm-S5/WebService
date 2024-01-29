package farm.demo.culture;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class HistoriqueCulture extends culture.CultureParcelle {
    Date recolte;

    public HistoriqueCulture(int idCultureParcelle, Date recolte) {
        super(idCultureParcelle);
        this.recolte = recolte;
    }

    public Date getRecolte() {
        return recolte;
    }

    public void setRecolte(Date recolte) {
        this.recolte = recolte;
    }

    public void addHistoriqueCulture(HistoriqueCulture h){
        try {
            connect.Connect c = new connect.Connect();
            Connection con = c.conekta();
            String sql = "insert into HistoriqueCulture (idCultureParcelle,dateRecolte) values (?,?)";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1, h.getIdCultureParcelle());
            psd.setDate(2, h.getRecolte());
            psd.executeUpdate();
            psd.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
