package worksFlow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extention.restAPI;
import io.restassured.response.Response;
import utilies.commonOps;

public class apiActions extends commonOps {
	private static String[] details = { "Dor", "Ingber", "POP1234@gmail.com", "Engineer" };
	private static List<String> subjects = new ArrayList<String>();

	public static void postNewStudent() throws ParserConfigurationException, SAXException, IOException {
		subjects.add("Math");
		subjects.add("English");
		subjects.add("art");
		restAPI.post(details, subjects);

	}

	public static Response getDeatils() throws ParserConfigurationException, SAXException, IOException {
		return restAPI.get(getData("API_URL") + getData("API_Resource") + "/list");

	}


}
