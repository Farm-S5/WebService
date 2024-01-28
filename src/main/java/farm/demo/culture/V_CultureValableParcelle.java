package farm.demo.culture;

import connect.Connect;

import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class V_CultureValableParcelle extends culture.Culture {
    int idParcelle;

    public V_CultureValableParcelle(int idParcelle,int idCulture, String nameCulture, float rendementM2, float prixM2, Time duration) {
        super(idCulture, nameCulture, rendementM2, prixM2, duration);
        this.idParcelle = idParcelle;
    }

    public V_CultureValableParcelle(){}

    public int getIdParcelle() {
        return idParcelle;
    }

    public void setIdParcelle(int idParcelle) {
        this.idParcelle = idParcelle;
    }

    public List<V_CultureValableParcelle> findCultureValableByIdParcelle(int id){
        List<V_CultureValableParcelle> p = new ArrayList<>();
        try {
            connect.Connect c = new Connect();
             Connection con = c.conekta();
            String sql = "Select * from v_CultureValableParcelle where idParcelle =?";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1,id);
            ResultSet rs = psd.executeQuery();
            while(rs.next()){
                p.add(new V_CultureValableParcelle(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getFloat(4),rs.getFloat(5),rs.getTime(6)));
            }
            psd.close();
            con.close();
            return p;
        }catch (Exception ex){
            ex.getStackTrace();
        }
        return p;
    }
}
