import java.util.List;
import java.sql.SQLException;

public interface Ads {
    // get a list of all the ads
    List<Ad> all() throws SQLException;
    // insert a new ad and return the new ad's id
    Long insert(Ad ad) throws SQLException;
}
