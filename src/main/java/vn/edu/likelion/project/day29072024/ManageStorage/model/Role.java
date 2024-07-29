package vn.edu.likelion.project.day29072024.ManageStorage.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Role {
    private int id;
    @NonNull
    private String name;

    public Role(int id) {
        this.id = id;
    }

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void show(){
        System.out.println("Role id: " + id);
        System.out.println("Role name: " + name);
    }
}
