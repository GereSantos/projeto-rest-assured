import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class VeiculosMockTest {

    @Test
    public void testListarVeiculosLocais() {
        // Apontando os mísseis para a NOSSA base (localhost)
        System.out.println("Iniciando varredura no servidor local...");

        given()
            .baseUri("http://localhost:3000") // <-- O endereço do seu novo reator
        .when()
            .get("/veiculos")
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0)) // Garante que a lista não veio vazia
            .log().all();
    }

    @Test
    public void testAdicionarVeiculoLocal() {
        System.out.println("Injetando novo veículo na base secreta...");

        String novoVeiculo = """
            {
                "id": "3",
                "modelo": "Porsche Taycan",
                "placa": "STARK-03",
                "status": "disponivel"
            }
            """;

        given()
            .baseUri("http://localhost:3000")
            .contentType("application/json")
            .body(novoVeiculo)
        .when()
            .post("/veiculos")
        .then()
            .statusCode(201) // 201 significa "Criado com sucesso"
            .log().all();
    }
}