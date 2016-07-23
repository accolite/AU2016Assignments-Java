import com.accolite.NewMessage;
import com.accolite.Query;

import java.sql.SQLException;

/**
 * Created by Mitul Kapoor on 7/23/2016.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Query query = new Query();
        System.out.println("reply : " + query.addMessage(new NewMessage(4,"asdasd",4)));
    }
}
