package day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;

public class OpenWithAPI {
  @Test

	public void getWeatherInfo() {

		/* Given > Pre-condition like content type,Authentication
		 * When > User performs something
		 * Then > expected outcome from System
		 */
		
		RestAssured.given()
		           .when()
		           .get("http://api.openweathermap.org/data/2.5/weather?q=hyderabad&appid=026582a999ef7e1d7f951f7b3e14e8b5")
	      
		           .then()
	               .log()
	               .body()
	               .statusCode(200);
  }
  @Test(enabled=false,description="Getting weather API ifo generally")
  public void getWeatherInfo2() {
	  
	 Response res=RestAssured.given()
	              .when()
	              .get("http://api.openweathermap.org/data/2.5/weather?q=hyderabad&appid=026582a999ef7e1d7f951f7b3e14e8b5");
	  System.out.println(res.prettyPrint());
	  System.out.println(res.getTime());
	  System.out.println(res.getStatusCode());
	  System.out.println(res.getContentType());
	              
  }
  @Test(enabled=true,description="Getting weather API ifo generally")
  public void getWeatherInfo3() {
	  Map<String,String>param=new HashMap<String,String>();
	  param.put("q","Hyderabad");
	  param.put("appid","563f35938249e8885aa209bdd3a60c31");
	  RestAssured.given()
	           //   .queryParam("q","Mumbai")
	             // .queryParam("appid", "563f35938249e8885aa209bdd3a60c31")
	              . params(param)
	              .when()
	              .get("http://api.openweathermap.org/data/2.5/weather")
	              .then()
	              .log()
	              .body()
	              .statusCode(200);
	
  }
}
