package pruebaQA;

import com.tngtech.java.junit.dataprovider.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


@RunWith(DataProviderRunner.class)
public class ParameterizingTest {

    @DataProvider
    public static Object[][] CheckAnswer() {
        return new Object[][]{
                {"yes"},
                {"no"},
                {"maybe"},
        };

    }

    @Test
    @UseDataProvider("CheckAnswer")
    public void requestDecisionFromCollection_checkAnswerInResponseBody_expectSpecifiedAnswer(String answer) {

        given().
                pathParam("answer", answer).
                when().
                get("https://yesno.wtf/api/{answer}").
                then().
                assertThat().equals("ExpectedAnswer");

    }

}