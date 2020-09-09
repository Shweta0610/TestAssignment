package com.pageobject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	Set<Integer> Unique_timer = new HashSet<Integer>();
	long Difference ;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//================ Home Page Web Elements ====================================================================	
	@FindBy(id = "start_a_timer") 
	private WebElement input_StartTimer;
	
	@FindBy(id = "timergo") 
	private WebElement btn_go;
	
	@FindBy(id = "progressText") 
	private WebElement TimerText;
	
	
	public void enter_Timer() {
		input_StartTimer.clear();
		input_StartTimer.sendKeys("25 Seconds");
	}
	
	public void click_Go() {
		int time=0;

		String Timer_text ="";
		Pattern p = Pattern.compile("\\d+");
		Date date = new Date();
        
		btn_go.click();
		
			
		do{
			Timer_text ="";
	        Matcher m = p.matcher(TimerText.getText());
	        while(m.find()) {
		        Timer_text = m.group();
	        }

	        time = Integer.parseInt(Timer_text);
	        Unique_timer.add(time);
	      }while(time>1);
		
        Date date2 = new Date();
        Difference = date2.getTime() - date.getTime();
        Difference = Difference/1000;
        System.out.println("Difference "+Difference);
		System.out.println("Timer set elements -->"+Unique_timer);
	}

	
	public void verifyTimerText() {	
		
		
		int i =1;		
		for (Integer number : Unique_timer) {
			if (i==number){
				i++;
			}
			else{
				Assert.fail("Decrement is not by 1");
				break;				
			}			
		}
		long Timer=25;
		if ((Timer - Difference)<5)
		{
			System.out.println("Timer worked for specified time !!");
		}
		else 
		{
			System.out.println("Timer did not work for specified time !!");
		}
	}
}
