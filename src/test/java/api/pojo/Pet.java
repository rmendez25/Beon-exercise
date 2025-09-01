package api.pojo;



import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private int id;
    private String name;
    private Category category;
    private List<String> photoUrls;
    private List<Tags> tags;
    private String status;

}
