package utilies;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class JDBC extends commonOps {

	public static Connection con;
	public static Statement stmt;
	public static ResultSet rs;

	public static void initJDBC()
			throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(getData("DB_URL"), getData("DB_User"), getData("DB_Password"));
		stmt = con.createStatement();

	}
	
	public static void retrieveInfo(String qury) throws SQLException {
		rs = stmt.executeQuery(qury);
	}
	
	public static String parseData() throws SQLException, ParserConfigurationException, SAXException, IOException {
		String value = null;
		while(rs.next()) {
			value = rs.getString(getData("Excpted_Result"));
		}
		return value;
	}
	
	public static void closeDBcon() throws SQLException {
		con.close();
	}

}

