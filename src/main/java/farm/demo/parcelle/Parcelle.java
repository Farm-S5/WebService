/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcelle;
import terrain.*;
import connect.*;
import java.util.*;
import java.sql.*;
/**
 *
 * @author loick
 */
public class Parcelle extends Terrain{
    int idParcelle;
    float rendement;
    float superficie;

    public Parcelle() {
    }

    public Parcelle(int idTerrain,int idParcelle, float rendement, float superficie) {
        super(idTerrain);
        this.idParcelle = idParcelle;
        this.rendement = rendement;
        this.superficie = superficie;
    }

    public Parcelle(int idTerrain,float rendement, float superficie) {
        super(idTerrain);
        this.rendement = rendement;
        this.superficie = superficie;
    }

    public Parcelle(int idParcelle) {
        this.idParcelle = idParcelle;
    }

    public int getIdParcelle() {
        return idParcelle;
    }

    public float getRendement() {
        return rendement;
    }

    public float getSuperficie() {
        return superficie;
    }

    public void setIdParcelle(int idParcelle) {
        this.idParcelle = idParcelle;
    }

    public void setRendement(float rendement) {
        this.rendement = rendement;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }
    
    
    public void insertParcelle(Parcelle p)
    {
        try{
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "insert into Parcelle (idTerrain,rendement,superficie) values (?,?,?)";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1, p.getIdTerrain());
            psd.setFloat(2, p.getRendement());
            psd.setFloat(3, p.getSuperficie());
            psd.executeUpdate();
            psd.close();
            con.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
        public List<Parcelle> findParcelle() {
        List<Parcelle> p = new ArrayList<>();
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "Select * from Parcelle";
            PreparedStatement psd = con.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            while (rs.next()) {
                p.add(new Parcelle(rs.getInt(1), rs.getInt(2),rs.getFloat(3),rs.getFloat(4)));
            }
            psd.close();
            con.close();
            return p;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    public Parcelle findParcelleByIdParcelle(int id) {
        Parcelle p = new Parcelle();
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "Select * from Parcelle where idParcelle=?";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1,id);
            ResultSet rs = psd.executeQuery();
            while (rs.next()) {
                p.setIdTerrain(rs.getInt(1));
                p.setIdParcelle(rs.getInt(2));
                p.setRendement(rs.getFloat(3));
                p.setSuperficie(rs.getFloat(4));
            }
            psd.close();
            con.close();
            return p;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    public List<Parcelle> findParcelleByIdTerrain(int id) {
        List<Parcelle> p = new ArrayList<>();
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "Select * from Parcelle where idTerrain=?";
            PreparedStatement psd = con.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            psd.setInt(1,id);
            while (rs.next()) {
                p.add(new Parcelle(rs.getInt(1), rs.getInt(2),rs.getFloat(3),rs.getFloat(4)));
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
