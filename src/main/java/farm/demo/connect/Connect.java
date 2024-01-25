package connect;
import java.sql.*;

public class Connect
{
    String user;
    String mdp;

    public Connect()
    {

    }

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
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/City", this.user, this.mdp);
        } catch (SQLException e) {
            throw e;
        }
        return con;
    }



    
}
