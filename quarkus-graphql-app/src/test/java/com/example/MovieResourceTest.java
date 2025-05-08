package com.example;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class MovieResourceTest {

  @Test
  public void sizeInvalidType() {
    String requestBody = """
            {
              "variables": {
                "paginationParams": {
                  "size": 50
                }
              },
              "query": "query ($paginationParams: PaginationParams!) {\\n  allFilms(paginationParams: $paginationParams) { title releaseDate } }"
            }
            """;

    Response response = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .when()
            .post("/graphql");

      Assertions.assertFalse(response.body().print().contains("errors"));
  }

  @Test
  public void beforeInvalidType() {
    String requestBody = """
            {
              "variables": {
                "paginationParams": {
                  "before": 0
                }
              },
              "query": "query ($paginationParams: PaginationParams!) {\\n  allFilms(paginationParams: $paginationParams) { title releaseDate } }"
            }
            """;

    Response response = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .when()
            .post("/graphql");

    Assertions.assertFalse(response.body().print().contains("errors"));
  }

}