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
    private String species = null;

    private String sex = null;

    private String status = null;

    private String org = null;

    private String age = null;

    private String sterilized = null;

    private String vaccinated = null;

    public List<Pet> filtering(List<Pet> pets) {
        //String query1 =
        //SelectQuery selectQ = new SelectQuery();
        //SelectQuery sel = new SelectQuery().addCondition(BinaryCondition.equalTo(species, "?"));
        //selectQ.addCustomization();
        //.validate().toString();

        return pets.stream()
                .filter(
                        (p) ->
                                (species.equals("species") || p.getSpecies().equals(species)) &&

                                        (sex.equals("sex") || p.getSex().equals(sex)) &&

                                        (status.equals("status") || p.getStatus().equals(status)) &&

                                        (org.equals("org") || p.getOrganizationID().equals(Long.parseLong(org))) &&

                                        ((age.equals("age") || (p.getAge() > 5) || (p.getAge() >= Integer.parseInt(age) && p.getAge() <= Integer.parseInt(age) + 1))) &&

                                        (sterilized.equals("sterilized") || p.getSterilized() == Boolean.valueOf(sterilized)) &&

                                        (vaccinated.equals("vaccinated") || p.getVaccinated() == Boolean.valueOf(vaccinated))

                ).collect(Collectors.toList());
    }
}

