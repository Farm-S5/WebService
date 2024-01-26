/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culture;

import java.sql.*;
import java.util.*;
import connect.*;
import parcelle.*;

/**
 *
 * @author loick
 */
public class Culture extends Parcelle {

    int idCulture;
    String nameCulture;
    float rendementM2;
    float prixM2;
    Time duration;

    public Culture() {
    }

    public Culture(int idCulture, String nameCulture, float rendementM2, float prixM2, Time duration) {
        this.idCulture = idCulture;
        this.nameCulture = nameCulture;
        this.rendementM2 = rendementM2;
        this.prixM2 = prixM2;
        this.duration = duration;
    }

    public Culture(int idCulture, String nameCulture) {
        this.idCulture = idCulture;
        this.nameCulture = nameCulture;
    }

    public Culture(int idCulture, int idParcelle) {
        super(idParcelle);
        this.idCulture = idCulture;
    }
    
    

    public int getIdCulture() {
        return idCulture;
    }

    public String getNameCulture() {
        return nameCulture;
    }

    public float getRendementM2() {
        return rendementM2;
    }

    public float getPrixM2() {
        return prixM2;
    }

    public Time getDuration() {
        return duration;
    }

    public void setIdCulture(int idCulture) {
        this.idCulture = idCulture;
    }

    public void setNameCulture(String nameCulture) {
        this.nameCulture = nameCulture;
    }

    public void setRendementM2(float rendementM2) {
        this.rendementM2 = rendementM2;
    }

    public void setPrixM2(float prixM2) {
        this.prixM2 = prixM2;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public void insertCulture(Culture cu) {
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "insert into culture (nameCulture,rendementM2,prixM2,duration) values (?,?,?,?)";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setString(1, cu.getNameCulture());
            psd.setFloat(2, cu.getRendementM2());
            psd.setFloat(3, cu.getPrixM2());
            psd.setTime(4, cu.getDuration());
            psd.executeUpdate();
            psd.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Culture> findCulture() {
        List<Culture> p = new ArrayList<>();
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "Select * from culture";
            PreparedStatement psd = con.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            while (rs.next()) {
                p.add(new Culture(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getTime(5)));
            }
            psd.close();
            con.close();
            return p;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    public List<Culture> findCultureName() {
        List<Culture> p = new ArrayList<>();
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "Select * from culture";
            PreparedStatement psd = con.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            while (rs.next()) {
                p.add(new Culture(rs.getInt(1), rs.getString(2)));
            }
            psd.close();
            con.close();
            return p;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    public void insertCultureValableParcelle(Culture cu) {
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "insert into culturevalableparcelle (idParcelle,idCulture) values (?,?)";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1, cu.getIdParcelle());
            psd.setInt(2, cu.getIdCulture());
            psd.executeUpdate();
            psd.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
