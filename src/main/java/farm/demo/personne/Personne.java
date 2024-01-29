/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personne;

import connect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author loick
 */
public class Personne {
    
    int idUser;
    String nameUser;
    String passUser;
    
    public Personne(int idUser, String nameUser, String passUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.passUser = passUser;
    }
    
    public Personne(String nameUser, String passUser) {
        this.nameUser = nameUser;
        this.passUser = passUser;
    }

    public Personne(int idUser, String nameUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
    }

    public Personne(int idUser) {
        this.idUser = idUser;
    }
    
    public Personne() {
    }
    
    public int getIdUser() {
        return idUser;
    }
    
    public String getNameUser() {
        return nameUser;
    }
    
    public String getPassUser() {
        return passUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
    
    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }
    
    public int checkPersonne(Personne p) throws Exception {
        int id = 0;
        try {
            connect.Connect c = new connect.Connect();
            Connection con = c.conekta();
            String sql = "Select * from personne where nameUser=? and passuser =?";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setString(1, p.getNameUser());
            psd.setString(2, p.getPassUser());
            ResultSet rs = psd.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            psd.close();
            con.close();
            c.endConnection(con);
            return id;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    public void insertPersonne(Personne p) throws Exception {
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "insert into personne (nameUser,passUser) values (?,?)";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setString(1, p.getNameUser());
            psd.setString(2, p.getPassUser());
            psd.executeUpdate();
            psd.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Personne> findPersonne() {
        List<Personne> p = new ArrayList<>();
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "Select * from personne";
            PreparedStatement psd = con.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            while (rs.next()) {
                p.add(new Personne(rs.getInt(1),rs.getString(2), rs.getString(3)));
            }
            psd.close();
            con.close();
            return p;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }
    
    public Personne findPersonneById(int i) {
        Personne p = new Personne();
        try {
            Connect c = new Connect();
            Connection con = c.conekta();
            String sql = "Select * from personne where iduser=?";
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setInt(1, i);
            ResultSet rs = psd.executeQuery();
            while (rs.next()) {
                p.setIdUser(rs.getInt(1));
                p.setNameUser(rs.getString(2));
                p.setPassUser(rs.getString(3));
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
