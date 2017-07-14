package org.kitpes.model.form;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mac on 14.07.17.
 */
@Data
@NoArgsConstructor
public class DatePetLostFound {
    private int day;

    private int month;

    private int year;

    public String dateConstruct() {
        return  day + "." + month + "." + year;
    }
}
