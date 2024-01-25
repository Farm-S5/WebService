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
public class TerrainPersonne extends Personne {

    int idTerrain;

    public TerrainPersonne(int idTerrain, int idUser) {
        super(idUser);
        this.idTerrain = idTerrain;
    }

    public TerrainPersonne() {
    }

    public int getIdTerrain() {
        return idTerrain;
    }

    public void insertTerrainPersonne(TerrainPersonne tp) {
        try {
            Connect c = new Connect("Farmer", "123");
            Connection con = c.conekta();
            String sql = "insert into PersonneTerrain (idUser,idTerrain) values (?,?)";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1, tp.getIdUser());
            psd.setInt(2, tp.getIdTerrain());
            psd.executeUpdate();
            psd.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
