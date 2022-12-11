package factory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class dbfactory {
	 public static HikariDataSource createMSSQLConnection() {
		  HikariConfig config = new HikariConfig("/db.properties");
		  HikariDataSource ds = new HikariDataSource(config);
		  return ds;
		 }
}
