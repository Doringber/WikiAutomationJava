package pageObject_imdb_moblie;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class resultPage {
	@FindBy(how = How.ID, using = "title")
	public WebElement firstResult;
}
