package com.vietsherlock.datastore.mapper;

import org.springframework.stereotype.Component;

import java.time.DateTimeException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeMapper {
    public OffsetDateTime toOffsetDateTime(String strTime){
        if (strTime == null)
            return null;

        if(isValidFormatTime("yyyy-MMM-dd HH:mm:ss Z", strTime)){
            OffsetDateTime dateTime1 = OffsetDateTime.parse(strTime,
                    DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss Z"));
            return dateTime1;
        }

        if(isValidFormatTime("yyyy-MM-dd KK:mm:ss a x", strTime)){
            OffsetDateTime dateTime2 = OffsetDateTime.parse(strTime,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd KK:mm:ss a x"));
            return dateTime2;
        }

        if(isValidFormatTime("cccc, MMMM dd, yyyy KK:mm a X", strTime)){
            OffsetDateTime dateTime3 = OffsetDateTime.parse(strTime,
                    DateTimeFormatter.ofPattern("cccc, MMMM dd, yyyy KK:mm a X"));
            return dateTime3;
        }

        return null;
    }

    public static boolean isValidFormatTime(String format, String value){

        try {
            CharSequence text;
            OffsetDateTime dateTime = OffsetDateTime.parse(value,
                    DateTimeFormatter.ofPattern(format));

            return true;
        }catch (DateTimeException ex){
            return false;
        }

    }


}
