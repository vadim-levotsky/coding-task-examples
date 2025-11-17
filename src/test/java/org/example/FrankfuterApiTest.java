package org.example;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FrankfuterApiTest {

    private static RequestSpecification spec;

    @BeforeAll
    public static void init() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://api.frankfurter.dev/v1")
                .log(LogDetail.ALL)
                .build();
    }

    @Test
    public void testOne() {
        Response response = given()
                .spec(spec)
                //.queryParam()
                .get("/latest")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println(response.asPrettyString());
        Assertions.assertThat((Float) response.path("rates.AUD")).isEqualTo(1.7794f);
    }

    @Test
    public void testOneOne() {
        Response response = given()
                .spec(spec)
                //.queryParam()
                .get("/latest")
                .then()
                .statusCode(200)
                .body("rates.AUD", equalTo(1.7794f))
                .extract()
                .response();
        System.out.println(response.asPrettyString());
        //Assertions.assertThat((Float) response.path("rates.AUD")).isEqualTo(1.7794f);
    }

    @Test
    public void testTwo() {
        Response response = given()
                .spec(spec)
                .queryParams(Map.of("symbols", "USD"))
                .when()
                .get("/2024-01-01..")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println(response.asPrettyString());
        Map<String, Float> rates = JsonPath.from(response.asString()).getMap("rates.2023-12-29");
        Assertions.assertThat(rates.get("USD")).isEqualTo(1.105f);
    }
}
