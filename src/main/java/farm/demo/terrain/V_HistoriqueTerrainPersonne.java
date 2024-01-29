package farm.demo.terrain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class V_HistoriqueTerrainPersonne extends terrain.HistoriqueTerrain {
    String nomAcheteur;
    String nomVendeur;

    public V_HistoriqueTerrainPersonne(int idHistorique, int idAcheteur,String nomAcheteur, int idVendeur,String nomVendeur, Date dateAchat) {
        super(idHistorique, idAcheteur, idVendeur, dateAchat);
        this.nomAcheteur = nomAcheteur;
        this.nomVendeur = nomVendeur;
    }

    public V_HistoriqueTerrainPersonne() {
    }

    public String getNomAcheteur() {
        return nomAcheteur;
    }

    public String getNomVendeur() {
        return nomVendeur;
    }

    public void setNomAcheteur(String nomAcheteur) {
        this.nomAcheteur = nomAcheteur;
    }

    public void setNomVendeur(String nomVendeur) {
        this.nomVendeur = nomVendeur;
    }

    public List<V_HistoriqueTerrainPersonne> findHistoriqueTerrain(){
        List<V_HistoriqueTerrainPersonne> h = new ArrayList<>();
        try{
            connect.Connect c = new connect.Connect();
            Connection con = c.conekta();
            String sql="select * from v_historiqueTerrainPersonne";
            PreparedStatement psd=con.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            while(rs.next()){
                h.add(new V_HistoriqueTerrainPersonne(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDate(6)));
            }
            psd.close();
            con.close();
            c.endConnection(con);
            return h;
        }catch (Exception ex){
            ex.getStackTrace();
        }
        return h;
    }

    public List<V_HistoriqueTerrainPersonne> findHistoriqueTerrainByIdAcheteur(int id){
        List<V_HistoriqueTerrainPersonne> h = new ArrayList<>();
        try{
            connect.Connect c= new connect.Connect();
            Connection con = c.conekta();
            String sql = "Select * from v_historiqueTerrainPersonne where idAcheteur=?";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1,id);
            ResultSet rs = psd.executeQuery();
            while(rs.next()){
                h.add(new V_HistoriqueTerrainPersonne(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDate(6)));
            }
            psd.close();
            con.close();
            c.endConnection(con);
            return h;
        }catch (Exception ex){
            ex.getStackTrace();
        }
        return h;
    }

    public List<V_HistoriqueTerrainPersonne> findHistoriqueTerrainByIdVendeur(int id){
        List<V_HistoriqueTerrainPersonne> h = new ArrayList<>();
        try{
            connect.Connect c= new connect.Connect();
            Connection con = c.conekta();
            String sql = "Select * from v_historiqueTerrainPersonne where idVendeur=?";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1,id);
            ResultSet rs = psd.executeQuery();
            while(rs.next()){
                h.add(new V_HistoriqueTerrainPersonne(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDate(6)));
            }
            psd.close();
            con.close();
            c.endConnection(con);
            return h;
        }catch (Exception ex){
            ex.getStackTrace();
        }
        return h;
    }
}
