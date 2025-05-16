package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MyStepdefs {
    Response response;
    @Given("User sends GET request to posts")
    public void userSendsGETRequestToPosts() {

        response=given().baseUri("https://jsonplaceholder.typicode.com/").when().get("/posts");
    }

    @Then("response should contain {int} post")
    public void responseShouldContainPost(int arg0) {
        response.then().assertThat().statusCode(200);
        List<Object> post = response.jsonPath().getList("$");
        Assert.assertEquals(arg0,post.size());

    }

    @And("Status code should be {int}")
    public void statusCodeShouldBe(int arg0) {
        Assert.assertEquals(arg0,response.getStatusCode());
    }

    @Given("User sends GET request to posts with ID{int}")
    public void userSendsGETRequestToPostsWithID(int arg0) {
        response=given().baseUri("https://jsonplaceholder.typicode.com/").when().get("/posts/"+arg0);
    }

    @Then("the title of the post should be {string}")
    public void theTitleOfThePostShouldBe(String arg0) {
        String title = response.jsonPath().getString("title");
        Assert.assertEquals(title,arg0);
    }

    @Given("User create a new post with the {string}, {string} and ID {int}")
    public void userCreateANewPostWithTheAndID(String arg0, String arg1, int arg2) {
        Map<String,Object>pass= new HashMap<>();
        pass.put("title",arg0);
        pass.put("body", arg1);
        pass.put("id",arg2);
        response= given().body(pass).baseUri("https://jsonplaceholder.typicode.com/").when().post("/posts");

    }

    @Then("The response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int arg0) {
        Assert.assertEquals(arg0,response.getStatusCode());
    }


    @And("The response should contain a post with ID")
    public void theResponseShouldContainAPostWithID() {
        int id = response.jsonPath().getInt("id");
        Assert.assertTrue("id should be grather 100", id>100);
    }

    @Given("User updates the post with ID {int} with title {string}, body {string}, and userid {int}")
    public void userUpdatesThePostWithIDWithTitleBodyAndUserid(int arg0, String arg1, String arg2, int arg3) {
        Map<String,Object>pass= new HashMap<>();
        pass.put("userId",arg3);
        pass.put("title",arg1);
        pass.put("body", arg2);
        pass.put("id",arg0);
        response= given().body(pass).baseUri("https://jsonplaceholder.typicode.com/").when().put("/posts/"+arg0);
        
    }

    @And("The response give id {int}")
    public void theResponseGiveId(int arg0) {
        int id= response.jsonPath().get("id");
        Assert.assertEquals(arg0,id);
    }



    @Given("User Sends DELETE request to post with ID {int}")
    public void userSendsDELETERequestToPostWithID(int arg0) {
        response=given().baseUri("https://jsonplaceholder.typicode.com/").when().delete("/posts/"+ arg0);
    }
}
