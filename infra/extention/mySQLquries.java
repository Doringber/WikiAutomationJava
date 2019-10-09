package extention;

import static org.testng.Assert.fail;

import com.relevantcodes.extentreports.LogStatus;

import utilies.JDBC;

public class mySQLquries extends JDBC {

	public static String queries(String qury) {
		String value = null;
		try {
			initJDBC();
			retrieveInfo(qury);
			value = parseData();
			closeDBcon();
			test.log(LogStatus.PASS, "Qury Successfully creted");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Qury to DB fail, see Details: " + e);
			fail("Qury to DB fail, see Details: " + e);
		}
		return value;
	}

}

