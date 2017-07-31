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
        if (day == 0) return null;
        else if (month == 0) return null;
        else if (year == 0) return null;
        else return day + "." + month + "." + year;
    }
}
