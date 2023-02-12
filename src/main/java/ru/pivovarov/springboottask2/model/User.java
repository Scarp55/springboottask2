package ru.pivovarov.springboottask2.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {

    @NotBlank
    @Size(min = 2, max = 30)
    private String name;
    @NotBlank
    @Size(min = 4, max = 8)
    private String password;
    private List<Authorities> authoritiesList;
}
