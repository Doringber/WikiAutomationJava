package worksFlow;

import extention.mySQLquries;

public class db_query {

	public static String	getMessage(String excpted_result,String value ) {
		return mySQLquries.queries("SELECT " + excpted_result + " FROM new_schema.wiki where excpted_result =" + value + ";");
	}
}
