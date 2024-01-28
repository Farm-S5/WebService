package farm.demo.terrain;
import java.sql.*;
import java.util.*;
import connect.*;
public class V_TerrainPersonne extends terrain.Terrain {
    int idUser;

    public V_TerrainPersonne(int idUser,int idTerrain, double longitude, double latitude, int nbParcelle, String descriptionTerrain, int etat) {
        super(idTerrain, longitude, latitude, nbParcelle, descriptionTerrain, etat);
        this.idUser = idUser;
    }

    public V_TerrainPersonne() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public List<V_TerrainPersonne> findTerrainPersonneNonValider(int idPersonne){
        List<V_TerrainPersonne> lt = new ArrayList<>();
        try {
            connect.Connect c = new connect.Connect();
            Connection con = c.conekta();
            String sql = "select * from V_TerrainPersonne where etat=0 and idUser=?";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1,idPersonne);
            ResultSet rs = psd.executeQuery();
            while (rs.next()) {
                lt.add(new V_TerrainPersonne(rs.getInt(1),rs.getInt(2), rs.getDouble(3), rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getInt(7)));
            }
            psd.close();
            con.close();
            return lt;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lt;
    }

    public List<V_TerrainPersonne> findTerrainPersonneValider(int idPersonne){
        List<V_TerrainPersonne> lt = new ArrayList<>();
        try {
            connect.Connect c = new connect.Connect();
            Connection con = c.conekta();
            String sql = "select * from V_TerrainPersonne where etat=1 and idUser=?";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1,idPersonne);
            ResultSet rs = psd.executeQuery();
            while (rs.next()) {
                lt.add(new V_TerrainPersonne(rs.getInt(1),rs.getInt(2), rs.getDouble(3), rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getInt(7)));
            }
            psd.close();
            con.close();
            return lt;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lt;
    }
}
