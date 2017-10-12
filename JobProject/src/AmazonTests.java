import org.openqa.selenium.firefox.*;
import org.openqa.selenium.firefox.amd64.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class AmazonTests {

	
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","C:\\Users\\SERGEN\\Downloads\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
	

		 String baseUrl = "https://www.amazon.com/";
		 String anaBaslik = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		 String aktifBaslik = "";
		 String sonuc="Amazon.com: samsung";
		 String aktifsonuc="";
		 String belirlisayfa1="25-48";
		 String belirlisayfa2="19-36";
		driver.get(baseUrl);
		aktifBaslik = driver.getTitle();
		 if (aktifBaslik.contentEquals(anaBaslik)){
	            System.out.println("Ana sayfa baþarýyla açýldý.");
	        } else {
	            System.out.println("Ana sayfa açýlamadý.");
	        }
		
		 driver.findElement(By.xpath(".//*[@id='nav-link-accountList']/span[2]")).click();
		 driver.findElement(By.xpath(".//*[@id='ap_email']")).sendKeys("testtaskk123@gmail.com");
		 driver.findElement(By.xpath(".//*[@id='ap_password']")).sendKeys("testtask123");
		 driver.findElement(By.xpath(".//*[@id='signInSubmit']")).click();//sisteme giriþ yapýlýyor.
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']")).sendKeys("samsung");
		 Thread.sleep(2000);
		
		 driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input")).click();
		 aktifsonuc = driver.getTitle();
		 if(aktifsonuc.contentEquals(sonuc)){
			 System.out.println("Samsung için sonuç bulundu.");
	        } else {
	            System.out.println("Samsung için sonuç bulunamadý.");
	        }
		 Thread.sleep(2000);
	     driver.findElement(By.xpath(".//*[@id='pagn']/span[3]/a")).click();
	     String acilansayfa = driver.findElement(By.id("s-result-count")).getText().split(" ")[0];
	     if(acilansayfa.contentEquals(belirlisayfa1)||acilansayfa.contentEquals(belirlisayfa2)){
			 System.out.println("2.sayfaya baþarýyla geçiþ yapýldý.");
	        } else {
	            System.out.println("2. sayfa açýlamadý.");
	        }
	     Thread.sleep(2000);//Denemelerin ardýndan 2 farklý sonuç olduðuna rastlandý.Buna uygun if koþulu oluþturuldu.
	     if(acilansayfa.contentEquals(belirlisayfa1)){
		 driver.findElement(By.xpath(".//*[@id='result_26']/div/div/div/div[2]/div[1]/div[1]/a/h2")).click();
	     }
	     else{
	    	 if(acilansayfa.contentEquals(belirlisayfa2)){
	    		 driver.findElement(By.xpath(".//*[@id='result_20']/div/div/div/div[2]/div[1]/div[1]/a/h2")).click();
	    	 }
	     }
		
		 Thread.sleep(2000);
		 driver.findElement(By.id("add-to-wishlist-button-submit")).click();
		    Thread.sleep(2000);
		    
		    driver.findElement(By.cssSelector("span.w-button-text")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.name("submit.deleteItem")).click();
		    System.out.println("Silme iþlemi baþarýlý");
		   
		   

		 
	}

}
