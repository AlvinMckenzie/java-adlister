import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;
public class MySQLAdsDao implements Ads{

    private Connection connection;
    private Config config;

    public MySQLAdsDao (Config config) {
        this.config = config;
    }
    @Override
    public List<Ad> all() throws SQLException {
        DriverManager.registerDriver(new Driver());
        this.connection = DriverManager.getConnection(config.getUrl(),config.getUser(),config.getPassword());
        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM ads");

        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(new Ad(
                    rs.getLong("id"),
                    rs.getLong("user_id"),
                    rs.getString("title"),
                    rs.getString("description")
            ));
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) throws SQLException {
        DriverManager.registerDriver(new Driver());
        this.connection = DriverManager.getConnection(config.getUrl(),config.getUser(),config.getPassword());
        Statement stmt = connection.createStatement();

        int result = stmt.executeUpdate("INSERT INTO ads (user_id, title, description) VALUES ('" + ad.getUserId() + "','" + ad.getTitle() + "','" + ad.getDescription() + "')", Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getLong(1);
        } else {
            return null;
        }
    }
}