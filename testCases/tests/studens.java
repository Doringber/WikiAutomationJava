package tests;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import extention.verfiyText;
import utilies.commonOps;
import worksFlow.apiActions;

public class studens extends commonOps {
	@Test
	public void test03_VerifyStudentCreated() throws ParserConfigurationException, SAXException, IOException 
	{
		apiActions.postNewStudent();
		verfiyText.contains(apiActions.getDeatils().getBody().asString(), "POP1234@gmail.com");
		
	}
	
}
