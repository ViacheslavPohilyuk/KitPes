package org.kitpes.date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by mac on 19.07.17.
 */
@Component
public class CurrentDateTimeZone {
    long getCurrentDate() {
        return new DateTime(DateTimeZone.UTC)
                .toDateTime(DateTimeZone.forID("Africa/Cairo"))
                .toDate()
                .getTime();
    }
}
