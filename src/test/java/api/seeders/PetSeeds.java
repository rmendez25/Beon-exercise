package api.seeders;

import api.pojo.Category;
import api.pojo.Pet;
import api.pojo.Tags;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class PetSeeds {

    static Faker faker = new Faker();

    public static Pet createPet() {
        Tags tags = new Tags();
        tags.setId(faker.number().randomDigit());
        tags.setName(faker.lorem().word());

        Category category = new Category();
        category.setId(faker.number().randomDigit());
        category.setName(faker.lorem().word());

        List<String> photos = new ArrayList<>();
        photos.add(faker.avatar().image());
        photos.add(faker.avatar().image());

        Pet pet = new Pet();
        pet.setId(faker.number().randomDigit());
        pet.setName(faker.animal().name());
        pet.setStatus("available");
        pet.setTags(List.of(tags));
        pet.setPhotoUrls(photos);
        pet.setCategory(category);

        return pet;
    }

    public static Pet updatePet(int id) {
        Tags tags = new Tags();
        tags.setId(faker.number().randomDigit());
        tags.setName(faker.lorem().word());

        Category category = new Category();
        category.setId(faker.number().randomDigit());
        category.setName(faker.lorem().word());

        List<String> photos = new ArrayList<>();
        photos.add(faker.avatar().image());
        photos.add(faker.avatar().image());

        Pet pet = new Pet();
        pet.setId(id);
        pet.setName(faker.animal().name());
        pet.setStatus("available");
        pet.setTags(List.of(tags));
        pet.setPhotoUrls(photos);
        pet.setCategory(category);

        return pet;
    }
}
