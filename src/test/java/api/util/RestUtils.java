package api.util;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestUtils {
    public static Response getOne(String url, int id) {
        return RestAssured
                .given()
                .spec(SpecBuilder.createSpec())
                .pathParam("id", id)
                .when()
                .get(url + "/{id}")
                .then()
                .extract()
                .response();
    }

    public static Response getPetsByStatus(String status) {
        return RestAssured.given()
                .spec(SpecBuilder.createSpec())
                .queryParam("status", status)  // dynamic status
                .when()
                .get("/api/v3/pet/findByStatus")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    public static Response getPetsByTag(String tag) {
        return RestAssured.given()
                .spec(SpecBuilder.createSpec())
                .queryParam("tags", tag)  // dynamic status
                .when()
                .get("/api/v3/pet/findByTags")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }


    public static Response post(String url, Object body) {
        return RestAssured
                .given()
                .spec(SpecBuilder.createSpec())
                .body(body)
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }

    public static Response update(String url, Object body) {
        return RestAssured
                .given()
                .spec(SpecBuilder.createSpec())
                .body(body)
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }

    public static Response deleteOne(String url, int id) {
        return RestAssured
                .given()
                .spec(SpecBuilder.createSpec())
                .pathParam("id", id)
                .when()
                .delete(url + "/{id}")
                .then()
                .extract()
                .response();
    }
}
