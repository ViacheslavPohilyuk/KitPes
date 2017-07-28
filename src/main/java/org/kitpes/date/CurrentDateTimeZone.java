package org.kitpes.date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;

/**
 * Created by mac on 19.07.17.
 */
public class CurrentDateTimeZone {
    long getCurrentDate() {
        return new DateTime(DateTimeZone.UTC)
                .toDateTime(DateTimeZone.forID("Africa/Cairo"))
                .toDate()
                .getTime();
    }
}
