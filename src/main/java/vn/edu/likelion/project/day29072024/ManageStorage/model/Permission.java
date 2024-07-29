package vn.edu.likelion.project.day29072024.ManageStorage.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Permission {
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String tablename;
}
