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

    public List<PhotoTerrain> findTerrainPhotoById(int id){
        List<PhotoTerrain> lt = new ArrayList<>();
        try {
            connect.Connect c = new connect.Connect();
            Connection con = c.conekta();
            String sql = "select * from PhotoTerrain where idTerrain=?";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1,id);
            ResultSet rs = psd.executeQuery();
            while (rs.next()) {
                String photos =rs.getString("photo");
                int idTerrain = rs.getInt("idTerrain");
                lt.add(new PhotoTerrain(Collections.singletonList(photos),idTerrain));
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
