package com.crm.qa.utilities;

import com.crm.qa.initialComponents.InitialSetups;

public class TestUtils extends InitialSetups{
	
	public void switchToFrameCRM() {
		driver.switchTo().frame("mainpanel");
	}

}
