package vn.edu.likelion.project.day29072024.ManageStorage.model;

import lombok.*;

import java.util.Base64;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private int id;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private Storage storage;
    @NonNull
    private Role role;
    @NonNull
    private List<Permission> permissions;

    public User(int id, String username, String password, Storage storage, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.storage = storage;
        this.role = role;
    }

    public User(String username, String password, Storage storage, Role role) {
        this.username = username;
        this.password = password;
        this.storage = storage;
        this.role = role;
    }

    public void show() {
        System.out.println("User Id: " + id);
        System.out.println("Username: " + username + "\nPassword: " + Base64.getDecoder().decode(password).toString());
    }
}
