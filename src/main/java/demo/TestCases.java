package demo;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.sql.Date;
import java.sql.Time;
import java.util.TimeZone;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.ThreeDLocation;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    WebDriverWait wait;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        //WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void googleFormAutomation() throws InterruptedException{
        try{
            System.out.println("Start Test case: googleFormAutomation");
            String formURL = "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform";
            getURL(driver, formURL);
            
            String userName = "Deepika";
            sendName(driver,userName);
            
            String whyAutomationReason="I want to be the best QA Engineer! ";
            whyAutomation(driver,whyAutomationReason);
            
            String AutoExp = "0 - 2";
            automationExperience(driver, AutoExp);

            String[] skillsLearnt = {"Java","Selenium","TestNG"};
            selectSkilsLearnt(driver, skillsLearnt);
            
            String myAddress = "Dr";
            shouldYouBeAddressed(driver, myAddress);

            dateSevenDaysAgo(driver);

            currentTimeNow(driver);
            Thread.sleep(3000);

            String amazonURL = "https://www.amazon.in/";
            getURL(driver, amazonURL);     
            
            Thread.sleep(1000);

            handleAlert(driver);

            Thread.sleep(1000);

            submitForm(driver,formURL);

            Thread.sleep(1000);

            checkResponseMessage(driver);

            Thread.sleep(5000);
            
            System.out.println("End Test case: googleFormAutomation");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void getURL(ChromeDriver driver, String URL){

        if(driver.getCurrentUrl()!=URL){
            driver.get(URL);

        }    


    }


    private void sendName(ChromeDriver driver,String userName){

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@jscontroller='oCiKKc']//div[contains(@class,'aXBtI Wic03c')]//div[@class='Xb9hP']/input[@jsname='YPqjbf']")));
        WebElement weName = driver.findElement(By.xpath("//div[@jscontroller='oCiKKc']//div[contains(@class,'aXBtI Wic03c')]//div[@class='Xb9hP']/input[@jsname='YPqjbf']"));
        weName.click();
        weName.sendKeys(userName);

    }

    private void whyAutomation(ChromeDriver driver, String whyAutomationReason){

        long epochTime = System.currentTimeMillis()/1000;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@jsname='YPqjbf']")));
        WebElement weWhyAutomation = driver.findElement(By.xpath("//textarea[@jsname='YPqjbf']"));
        weWhyAutomation.click();
        weWhyAutomation.sendKeys(whyAutomationReason+" "+epochTime);



    }

    private void automationExperience(ChromeDriver driver, String AutoExp){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+AutoExp+"']/../../preceding-sibling::div/div[@id='i13']")));
        WebElement weMyAutoExp = driver.findElement(By.xpath("//span[text()='"+AutoExp+"']/../../preceding-sibling::div/div[@id='i13']"));
        weMyAutoExp.click();   


    }

    private void selectSkilsLearnt(ChromeDriver driver, String[] skillsLearnt){

        List<WebElement> weSkillsLearnt = driver.findElements(By.xpath("//span[contains(@class,'aDTYNe snByac n5vBHf OIC90c')]"));
        for(String eachSkillLearnt : skillsLearnt){
            for(int i = 0; i < weSkillsLearnt.size(); i++){
                if(weSkillsLearnt.get(i).getText().equals(eachSkillLearnt)){
                    
                    WebElement weSkillCheckBox = driver.findElement(By.xpath("//span[(contains(@class,'aDTYNe snByac n5vBHf OIC90c')) and (text()='"+eachSkillLearnt+"')]"));
                    
                    JavascriptExecutor js = (JavascriptExecutor)driver;
                    
                    js.executeScript("arguments[0].scrollIntoView(true)",weSkillCheckBox);
                    weSkillCheckBox.click();
                }
            }

        }
    }

    private void shouldYouBeAddressed(ChromeDriver driver, String myAddress) throws InterruptedException{
        
        try{
            Thread.sleep(3000);
            WebElement weDropdownAddress = driver.findElement(By.xpath("//span[text()='Choose']/../../following-sibling::div"));
            weDropdownAddress.click();
            
            Thread.sleep(3000);

            WebElement weMyAddress = driver.findElement(By.xpath("//div[@jsname='V68bde']//span[@class='vRMGwf oJeWuf' and text()='"+myAddress+"']"));
            weMyAddress.click();    

            Thread.sleep(3000);

            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+myAddress+"']")));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    private void dateSevenDaysAgo(ChromeDriver driver){


        LocalDate date = LocalDate.now();
        LocalDate newdate = date.minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Current Date : "+date.format(formatter));
        System.out.println("New Date : "+newdate.format(formatter));

        WebElement weDateSevenDaysAgo = driver.findElement(By.xpath("//input[@type='date']"));
        weDateSevenDaysAgo.sendKeys(newdate.format(formatter));
        
    }

    public void currentTimeNow(ChromeDriver driver){

        LocalTime time = LocalTime.now();
        System.out.println("Current Time : "+time);
        DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("hh");
        DateTimeFormatter minuteFormat = DateTimeFormatter.ofPattern("mm");
        DateTimeFormatter ampmFormat = DateTimeFormatter.ofPattern("a");
        System.out.println("Current hours : "+time.format(hourFormat));
        System.out.println("Current minutes : "+time.format(minuteFormat));
        System.out.println("Current am/pm : "+time.format(ampmFormat));

        WebElement weCurrentTimeInHours = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        WebElement weCurrentTimeInMinutes = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        
        

        weCurrentTimeInHours.sendKeys(time.format(hourFormat));
        weCurrentTimeInMinutes.sendKeys(time.format(minuteFormat));


        //WebElement weDropdownAMPM = driver.findElement(By.xpath("//div[@data-value='AM']"));
        //weDropdownAMPM.click();



        //WebElement weAMPM = driver.findElement(By.xpath("//div[@aria-label='AM or PM']//span"));
        
    }
     
    private void handleAlert(ChromeDriver driver){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

    }
    
    
    private void submitForm(ChromeDriver driver, String formURL){

        WebElement weSubmit = driver.findElement(By.xpath("//span[text()='Submit']"));
        weSubmit.click();
        
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(formURL)));


    }

    private void checkResponseMessage(ChromeDriver driver){

        WebElement weSuccessMessage = driver.findElement(By.xpath("//div[@class='vHW8K']"));
        
        System.out.println(weSuccessMessage.getText());//Thanks for your response, Automation Wizard!
        
    }
}   

