package getRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.core.Is;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetData {
    @Test
    public void testResponsecode(){
        Response res=RestAssured.get("https://api.victoriassecret.com/settings/v1/languages?activeCountry=US");
        int code=res.getStatusCode();
        System.out.println("Status code of the request is "+code);
        Assert.assertEquals(code,200);
    }
   @Test
    public void testBody(){
       Response res=RestAssured.get("https://api.victoriassecret.com/settings/v1/languages?activeCountry=US");
       res.then().assertThat().body("languageDescription[0]", Is.is("English"));
       res.then().assertThat().body("languageCode[0]", Is.is("en"));
       res.then().assertThat().body("proxyLocation[0]", Is.is("www"));
       res.then().assertThat().body("eshopLanguageCode[0]", Is.is("en-IE"));
       res.then().assertThat().body("brand[0]", Is.is("VS"));
    }
}
