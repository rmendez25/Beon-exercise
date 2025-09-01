package api.tests;

import api.pojo.Pet;
import api.seeders.PetSeeds;
import api.util.RestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CrudApiTest {

    @Test
    public void getPetById() {
        Response response = RestUtils.getOne("/api/v3/pet", 1);
        JsonPath jsonPath = response.jsonPath();

        assertThat(jsonPath.getString("name"), equalTo("Pet1"));
        assertThat(jsonPath.getList("photoUrls").get(0), equalTo("test1"));
        assertThat(jsonPath.getList("photoUrls").get(1), equalTo("test2"));
        assertThat(jsonPath.getString("status"), equalTo("available"));
    }

    @Test
    public void getPetByStatus() {
        Response response = RestUtils.getPetsByStatus("available");
        JsonPath jsonPath = response.jsonPath();

        assertThat(jsonPath.getList("$"), is(not(empty())));
    }

    @Test
    public void createPet() {
        Pet petPayload = PetSeeds.createPet();
        Pet pet = RestUtils.post("/api/v3/pet", petPayload).as(Pet.class);

        assertThat(pet.getName(), equalTo(petPayload.getName()));
        assertThat(pet.getId(), equalTo(petPayload.getId()));
        assertThat(pet.getStatus(), equalTo(petPayload.getStatus()));
        assertThat(pet.getPhotoUrls().get(0), equalTo(petPayload.getPhotoUrls().get(0)));
        assertThat(pet.getCategory().getName(), equalTo(petPayload.getCategory().getName()));
        assertThat(pet.getTags().get(0).getName(), equalTo(petPayload.getTags().get(0).getName()));

    }

    @Test
    public void updatePet() {
        Pet petPayload = PetSeeds.createPet();
        int petId = RestUtils.post("/api/v3/pet", petPayload).as(Pet.class).getId();


        Pet updatePayload = PetSeeds.updatePet(petId);
        Pet pet = RestUtils.update("/api/v3/pet", updatePayload).as(Pet.class);

        assertThat(pet.getName(), equalTo(updatePayload.getName()));
        assertThat(pet.getId(), equalTo(updatePayload.getId()));
        assertThat(pet.getStatus(), equalTo(updatePayload.getStatus()));
        assertThat(pet.getPhotoUrls().get(0), equalTo(updatePayload.getPhotoUrls().get(0)));
        assertThat(pet.getCategory().getName(), equalTo(updatePayload.getCategory().getName()));
        assertThat(pet.getTags().get(0).getName(), equalTo(updatePayload.getTags().get(0).getName()));

    }

    @Test
    public void deletePet() {
        Pet petPayload = PetSeeds.createPet();
        int petId = RestUtils.post("/api/v3/pet", petPayload).as(Pet.class).getId();

        Response response = RestUtils.deleteOne("/api/v3/pet", petId);
        assertThat(response.statusCode(), equalTo(200));

    }
}
