/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terrain;

import connect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import personne.*;
/**
 *
 * @author loick
 */
public class HistoriqueTerrain {
    int idHistorique;
    int idAcheteur;
    int idVendeur;
    Date dateAchat;

    public HistoriqueTerrain() {
    }

    public HistoriqueTerrain(int idHistorique, int idAcheteur, int idVendeur, Date dateAchat) {
        this.idHistorique = idHistorique;
        this.idAcheteur = idAcheteur;
        this.idVendeur = idVendeur;
        this.dateAchat = dateAchat;
    }

    public int getIdHistorique() {
        return idHistorique;
    }

    public int getIdAcheteur() {
        return idAcheteur;
    }

    public int getIdVendeur() {
        return idVendeur;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setIdHistorique(int idHistorique) {
        this.idHistorique = idHistorique;
    }

    public void setIdAcheteur(int idAcheteur) {
        this.idAcheteur = idAcheteur;
    }

    public void setIdVendeur(int idVendeur) {
        this.idVendeur = idVendeur;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }
    
    public void insertHistoriqueTerrain(HistoriqueTerrain ht)
    {
                try {
            Connect c = new Connect("Farmer", "123");
            Connection con = c.conekta();
            String sql = "insert into HistoriqueTerrain (idAcheteur,idVendeur,dateAchat) values (?,?,?)";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1, ht.getIdAcheteur());
            psd.setInt(2, ht.getIdVendeur());
            psd.setDate(3,ht.getDateAchat());
            psd.executeUpdate();
            psd.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
