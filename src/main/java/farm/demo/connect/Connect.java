package connect;
import java.sql.*;

public class Connect
{
    String user;
    String mdp;

    public Connect()
    {}

    public Connect(String nom, String mdp)
    {
        this.user=nom;
        this.mdp =mdp;
    }
    public String getUser()
    {
        return this.user;
    }
    public void setUser(String nom)
    {
        this.user=nom;
    }
    public String getMdp()
    {
        return this.mdp;
    }
    public void setMdp(String mdp)
    {
        this.mdp = mdp;
    }
    public Connection conekta() throws SQLException, ClassNotFoundException {
        Connection con = null;
        try {
            String jdbcUrl = "jdbc:postgresql://monorail.proxy.rlwy.net:23536/railway";
            String user ="postgres";
            String mdp="fa5fE564AAAf2*51dgBAbdb4c-gC-d5F";
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(jdbcUrl,user,mdp);
        } catch (SQLException e) {
            throw e;
        }
        return con;
    }

    public void endConnection(Connection con) {
        try{
            con.close();
        }catch (Exception ex){
            ex.getStackTrace();
        }

    }



    
}
