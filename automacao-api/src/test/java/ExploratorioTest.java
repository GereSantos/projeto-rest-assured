import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ExploratorioTest {

    private static String token; // Variável para guardar a chave mestra

    @Test
    public void testFluxoCompletoReserva() {
        // PASSO 1: Gerar o Token automaticamente
        token = given()
            .baseUri("https://restful-booker.herokuapp.com")
            .contentType("application/json")
            .body("""
                {
                    "username" : "admin",
                    "password" : "password123"
                }
                """)
        .when()
            .post("/auth")
        .then()
            .statusCode(200)
            .extract()
            .path("token"); // Extrai o valor do token e salva na variável

        System.out.println("Chave de acesso gerada: " + token);

        // PASSO 2: Criar uma reserva e pegar o ID dela
        int bookingId = given()
            .baseUri("https://restful-booker.herokuapp.com")
            .contentType("application/json")
            .body("""
                {
                    "firstname" : "Tony",
                    "lastname" : "Stark",
                    "totalprice" : 5000,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2026-03-10",
                        "checkout" : "2026-03-15"
                    },
                    "additionalneeds" : "Armadura"
                }
                """)
        .when()
            .post("/booking")
        .then()
            .statusCode(200)
            .extract()
            .path("bookingid");

        // PASSO 3: Usar o Token e o ID para atualizar (O que deu erro antes!)
        given()
            .baseUri("https://restful-booker.herokuapp.com")
            .contentType("application/json")
            .accept("application/json")
            .header("Cookie", "token=" + token) // Usa o token novo automaticamente
            .body("""
                {
                    "firstname" : "Iron",
                    "lastname" : "Man",
                    "totalprice" : 9000,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2026-03-10",
                        "checkout" : "2026-03-15"
                    },
                    "additionalneeds" : "Upgrade de Reator"
                }
                """)
        .when()
            .put("/booking/" + bookingId) // Usa o ID que acabou de ser criado
        .then()
            .statusCode(200)
            .body("firstname", is("Iron"))
            .log().all();

            // PASSO 4: Destruir a reserva (Limpar os rastros)
        System.out.println("Iniciando protocolo de limpeza para o ID: " + bookingId);
        
        given()
            .baseUri("https://restful-booker.herokuapp.com")
            .contentType("application/json")
            .header("Cookie", "token=" + token)
        .when()
            .delete("/booking/" + bookingId)
        .then()
            .statusCode(201) // Curiosidade: A Restful-booker devolve 201 (Created) no Delete em vez de 200. Loucura deles.
            .log().all();
    }

    
}