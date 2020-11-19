package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import objectRepository.SectionFifteenOR;
import resources.Generic;

public class SectionFifteen {
	
		Generic generic = new Generic();
	
	public void searchItems() {
			
			Generic.FindElementByCSS(SectionFifteenOR.searchItemsByCss).sendKeys("C");
			List<WebElement> filteredList = Generic.FindElementsByXpath(SectionFifteenOR.filterItemsByXpath);
			filteredList.stream().filter(s->s.getText().contains("Cheese")).map(s->getPriceValue(s)).forEach(s->System.out.println(s));
			System.out.println("Develop Branch Code");
	}
		
	private static String getPriceValue(WebElement s) {
			
			String itemPrice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
			return itemPrice;
		}

}
