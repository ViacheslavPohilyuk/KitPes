package org.kitpes.model.filter;

import lombok.Data;
import org.kitpes.model.Pet;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mac on 29.06.17.
 */
@Data
public class FilterPet {
    private String species;

    private String sex;

    private String status;

    private String org;

    private String age;

    public List<Pet> filtering(List<Pet> pets) {
        return pets.stream()
                .filter(
                        (p) ->
                        (species.equals("species") || p.getSpecies().equals(species)) &&
                        (sex.equals("sex") || p.getSex().equals(sex)) &&
                        (status.equals("status") || p.getStatus().equals(status)) &&
                        (org.equals("org") || p.getOrganizationID().equals(Long.parseLong(org))) &&
                        (age.equals("age") || (p.getAge() > 5) || (p.getAge() >= Integer.parseInt(age) &&
                                                                   p.getAge() <= (Integer.parseInt(age) + 1))
                        )
                ).collect(Collectors.toList());
    }
}

