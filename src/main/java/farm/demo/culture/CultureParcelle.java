/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culture;

import java.sql.*;
import java.util.*;
import connect.*;

/**
 *
 * @author loick
 */
public class CultureParcelle extends Culture {

    int idCultureParcelle;
    Timestamp datePlantation;

    public CultureParcelle(int idCultureParcelle, Timestamp datePlantation, int idCulture, int idParcelle) {
        super(idCulture, idParcelle);
        this.idCultureParcelle = idCultureParcelle;
        this.datePlantation = datePlantation;
    }

    public CultureParcelle(int idCulture, int idParcelle, Timestamp datePlantation) {
        super(idCulture, idParcelle);
        this.datePlantation = datePlantation;
    }

    public CultureParcelle(int idCultureParcelle) {
        this.idCultureParcelle = idCultureParcelle;
    }

    public CultureParcelle() {
    }

    public CultureParcelle(int idCultureParcelle, Timestamp datePlantation) {
        this.idCultureParcelle = idCultureParcelle;
        this.datePlantation = datePlantation;
    }

    public int getIdCultureParcelle() {
        return idCultureParcelle;
    }

    public Timestamp getDatePlantation() {
        return datePlantation;
    }

    public void setIdCultureParcelle(int idCultureParcelle) {
        this.idCultureParcelle = idCultureParcelle;
    }

    public void setDatePlantation(Timestamp datePlantation) {
        this.datePlantation = datePlantation;
    }

    // Plantation
    public void insertCultureParcelle(CultureParcelle cp) {
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "insert into CultureParcelle (idParcelle,idCulture,dateplantation) values (?,?,?)";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1, cp.getIdParcelle());
            psd.setInt(2, cp.getIdCulture());
            psd.setTimestamp(3, cp.getDatePlantation());
            psd.executeUpdate();
            psd.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertHistoriqueCulture(CultureParcelle cp) {
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "insert into HistoriqueCulture (idCultureParcelle,dateRecolte) values (?,?)";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1,cp.getIdCultureParcelle());
            psd.setTimestamp(2,cp.getDatePlantation());
            psd.executeUpdate();
            psd.close();
            con.close();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
