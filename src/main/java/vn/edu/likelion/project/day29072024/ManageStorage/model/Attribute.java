package vn.edu.likelion.project.day29072024.ManageStorage.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Attribute {
    private int id;
    @NonNull
    private String name;
    private int productId;

    public Attribute(String name, int productId) {
        this.name = name;
        this.productId = productId;
    }

    public void show() {
        System.out.println("    ID: " + id);
        System.out.println("    Name: " + name);
    }
}
