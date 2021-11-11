package day1;

import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GithubExample {
  @Test(enabled=true,description="Getting all respositories")
  
  public void getAllRepo() {
	  given()
	  .auth()
	  .oauth2("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")
	  .when()
	  .get("https://api.github.com/user/repos")
	  // .get(" https://api.github.com/orgs/ORG/repos")
	  .then()
	  .log()
	  .body()
	  .statusCode(200)
	  .time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);
	  
  }
  @Test(enabled=true,description="Adding repository")
  public void addRepository() {
   JSONObject js=new JSONObject();
 js.put("name","tsl968-Rest");
 js.put("description","I am created by Rest");
 js.put("homepage","https://github.com/kasmurbee");

 given()
 .auth()
 .oauth2("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")
 .header("Content-Type","application/json")
 .body(js.toJSONString())
 .when()
 .post("https://api.github.com/user/repos")
 .then()
 .log()
 .body()
 .statusCode(201)
 .time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS);  
   } 
   }
