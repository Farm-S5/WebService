/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terrain;

import java.util.*;
import connect.*;
import java.sql.*;

/**
 *
 * @author loick
 */
public class PhotoTerrain extends Terrain{
    List<String> photos;

    public PhotoTerrain(List<String> photos, int idTerrain) {
        super(idTerrain);
        this.photos = photos;
    }

    public PhotoTerrain() {
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }
    
    public void insertPhotoTerrain(Map<String, Object> requestBody) {
        int idTerrain = (int) requestBody.get("idTerrain");
        List<String> photos = (List<String>) requestBody.get("photos");

        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "insert into PhotoTerrain (idTerrain, photo) values (?, ?)";
            PreparedStatement psd = con.prepareStatement(sql);

            for (String photo : photos) {
                psd.setInt(1, idTerrain);
                psd.setString(2, photo);
                psd.executeUpdate();
            }

            psd.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
