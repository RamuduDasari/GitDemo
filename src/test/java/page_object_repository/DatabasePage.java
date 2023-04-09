package page_object_repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;

import configurations.Driver;
import configurations.ExcelUtils;

public class DatabasePage extends Driver {

	public static Connection con;
	public static Statement stmt;
	public String username;
	public String password;

	LoginPage loginpage = new LoginPage(driver);
	ExcelUtils excel  = new ExcelUtils(excelpath,"Sheet1");
    
	public   DatabasePage(WebDriver driver) throws Exception {

		// Register Mysql driver name
		Class.forName("com.mysql.cj.jdbc.Driver");
		// connect to the database
		String mysqlurl =excel.getCellData(6, 0);
		String dbusername =excel.getCellData(6, 1);
		String dbuserpwd = excel.getCellData(6, 2);
		
		con = DriverManager.getConnection(mysqlurl,dbusername,dbuserpwd );
		// create statement
		stmt = con.createStatement();
		// Result set
		ResultSet rs = stmt.executeQuery("select * from csedata;");
		while (rs.next()) {
			username = rs.getString("username");
			password = rs.getString("passwd");
		}
		if(con != null)
		{
			con.close();
		}
	}

	public void loginData() throws SQLException {
		loginpage.lnkLogin.click();
		loginpage.txtusername.sendKeys(username);
		loginpage.txtpassword.sendKeys(password);
		loginpage.btnsubmmit.click();
	}

}
