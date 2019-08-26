package pruebaQA;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class AutomationTest {



    @Test
    public void requestDecision_checkStatusCode () {

        given().
        when().
                get("https://yesno.wtf/api").
        then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void requestDecision_checkContentType() {

        given().
        when().
                get("https://yesno.wtf/api").
        then().
                assertThat().
                contentType(ContentType.JSON);

    }

    @Test
    public void requestDecision_logRequest() {

        given().
               log().all().
        when().
                get("https://yesno.wtf/api").
        then().
                log().body();

    }

    @Test
    public void requestDecision_checkAnswerInResponseBody_ExpectYes() {

        given().
        when().
                get("https://yesno.wtf/api?force=yes").
        then().
                assertThat().
                body("answer", equalTo("yes"));

    }

    @Test
    public void requestDecision_checkAnswerInResponseBody_ExpectNo() {

        given().
        when().
                get("https://yesno.wtf/api?force=no").
        then().
                assertThat().
                body("answer", equalTo("no"));

    }

    @Test
    public void requestDecision_checkAnswerInResponseBody_ExpectMaybe() {

        given().
        when().
                get("https://yesno.wtf/api?force=maybe").
        then().
                assertThat().
                body("answer", equalTo("maybe"));

    }
}

