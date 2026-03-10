import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class ExploratorioTest {

    @Test
    public void testListarReservas() {
        // O Rest Assured usa a lógica GIVEN (Dado), WHEN (Quando), THEN (Então).
        
        given()
            .baseUri("https://restful-booker.herokuapp.com")
        .when()
            .get("/booking")
        .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    public void testGerarToken() {
        // Ensinando o robô a fazer POST com envio de dados (Body)
        
        given()
            .baseUri("https://restful-booker.herokuapp.com")
            .contentType("application/json")
            .body("{\n" +
                  "    \"username\" : \"admin\",\n" +
                  "    \"password\" : \"password123\"\n" +
                  "}")
        .when()
            .post("/auth")
        .then()
            .statusCode(200)
            .log().all();
    }
}