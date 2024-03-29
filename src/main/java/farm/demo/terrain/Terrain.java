/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terrain;

import connect.*;
import connect.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author loick
 */
public class Terrain {

    int idTerrain;
    double longitude;
    double latitude;
    int nbParcelle;
    String descriptionTerrain;
    int etat;

    public Terrain() {
    }

    public Terrain(int idTerrain) {
        this.idTerrain = idTerrain;
    }

    public Terrain(int idTerrain, double longitude, double latitude, int nbParcelle, String descriptionTerrain, int etat) {
        this.idTerrain = idTerrain;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nbParcelle = nbParcelle;
        this.descriptionTerrain = descriptionTerrain;
        this.etat = etat;
    }

    public Terrain(double longitude, double latitude, int nbParcelle, String descriptionTerrain, int etat) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.nbParcelle = nbParcelle;
        this.descriptionTerrain = descriptionTerrain;
        this.etat = etat;
    }

    public Terrain(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Terrain(int idTerrain, int nbParcelle, String descriptionTerrain, int etat) {
        this.idTerrain = idTerrain;
        this.nbParcelle = nbParcelle;
        this.descriptionTerrain = descriptionTerrain;
        this.etat = etat;
    }

    public Terrain(int idTerrain, double longitude, double latitude, int nbParcelle, String descriptionTerrain) {
        this.idTerrain = idTerrain;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nbParcelle = nbParcelle;
        this.descriptionTerrain = descriptionTerrain;
    }

    public int getIdTerrain() {
        return idTerrain;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public int getNbParcelle() {
        return nbParcelle;
    }

    public String getDescriptionTerrain() {
        return descriptionTerrain;
    }

    public int getEtat() {
        return etat;
    }

    public void setIdTerrain(int idTerrain) {
        this.idTerrain = idTerrain;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setNbParcelle(int nbParcelle) {
        this.nbParcelle = nbParcelle;
    }

    public void setDescriptionTerrain(String descriptionTerrain) {
        this.descriptionTerrain = descriptionTerrain;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int insertTerrain(Terrain t) throws Exception {
        int generatedId = -1;
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "INSERT INTO Terrain (longitude, latitude, nbParcelle, descriptionterrain, etat) VALUES (?, ?, ?, ?, 0) RETURNING idTerrain";
            PreparedStatement psd = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psd.setDouble(1, t.getLongitude());
            psd.setDouble(2, t.getLatitude());
            psd.setInt(3, t.getNbParcelle());
            psd.setString(4, t.getDescriptionTerrain());

            int affectedRows = psd.executeUpdate();

            if (affectedRows > 0) {
                ResultSet rs = psd.getGeneratedKeys();
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }
            psd.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
        return generatedId;
    }

    public void changeEtatTerrain(int id) {
        try {
            connect.Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "Update terrain set etat=1 where idTerrain=?";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1, id);
            psd.executeUpdate();
            psd.close();
            con.close();
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    public List<Terrain> findTerrain() throws Exception {
        List<Terrain> lt = new ArrayList<>();
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "select * from Terrain";
            PreparedStatement psd = con.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            while (rs.next()) {
                lt.add(new Terrain(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getInt(6)));
            }
            psd.close();
            con.close();
            return lt;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lt;
    }

    public Terrain getDimension(int t) {
        Terrain u = new Terrain();
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "Select longitude,latitude from terrain where idTerrain =?";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1, t);
            ResultSet rs = psd.executeQuery();
            while (rs.next()) {
                u.setLongitude(rs.getFloat(1));
                u.setLatitude(rs.getFloat(2));
            }
            psd.close();
            con.close();
            return u;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return u;
    }

    public Terrain findTerrainById(int t) {
        Terrain u = new Terrain();
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "Select * from terrain where idTerrain =?";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1, t);
            ResultSet rs = psd.executeQuery();
            while (rs.next()) {
                u.setIdTerrain(rs.getInt(1));
                u.setLongitude(rs.getFloat(2));
                u.setLatitude(rs.getFloat(3));
                u.setNbParcelle(rs.getInt(4));
                u.setDescriptionTerrain(rs.getString(5));
                u.setEtat(rs.getInt(6));
            }
            psd.close();
            con.close();
            return u;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return u;
    }

    public List<Terrain> findTerrainEtat1() {
        List<Terrain> lt = new ArrayList<>();
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "select * from Terrain where etat=1";
            PreparedStatement psd = con.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            while (rs.next()) {
                lt.add(new Terrain(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getInt(6)));
            }
            psd.close();
            con.close();
            return lt;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lt;
    }

    public List<Terrain> findTerrainEtat0() {
        List<Terrain> lt = new ArrayList<>();
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "select * from Terrain where etat=0";
            PreparedStatement psd = con.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            while (rs.next()) {
                lt.add(new Terrain(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getInt(6)));
            }
            psd.close();
            con.close();
            return lt;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lt;
    }

    public void changeDetailTerrain(Terrain t){
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "update Terrain set nbParcelle =? ,descriptionterrain= ? , etat =? where idTerrain=?";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1, t.getNbParcelle());
            psd.setString(2, t.getDescriptionTerrain());
            psd.setInt(3, t.getEtat());
            psd.setInt(4, t.getIdTerrain());
            psd.executeUpdate();
            psd.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
