package extention;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import utilies.commonOps;

public class restAPI extends commonOps {
	@SuppressWarnings("unchecked")
	public static void post(String[] params, List<String> courseList) throws ParserConfigurationException, SAXException, IOException
	{
		try {
			requestParams.put("firstName", params[0]);
			requestParams.put("lastName", params[1]);
			requestParams.put("email", params[2]);
			requestParams.put("programme", params[3]);
			requestParams.put("courses", courseList);
			
			httpRequest.header("Content-Type","application/json");
			httpRequest.body(requestParams.toJSONString());
			
			httpRequest.post(getData("API_Resource"));
			test.log(LogStatus.PASS, "Post Succeeded");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Post has been failed, see info here: " + e);
			fail("Post has been failed, see info here:" + e);
		}
	

		
	}
	
	public static Response get(String URL)
	{
		resp = httpRequest.get(URL);
		return resp;
		
	}


}
