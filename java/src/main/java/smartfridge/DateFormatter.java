// Copyright (c) 2008-2022  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package smartfridge;

import java.time.*;
import java.time.format.*;

public class DateFormatter {

    public static LocalDate getLocalDateFromString(String dateString) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateString, formatter);
    }

    public static LocalDateTime getLocalDateTimeFromString(String dateString) throws DateTimeParseException {
        LocalDate localDateFromString = getLocalDateFromString(dateString);
        return localDateFromString.atStartOfDay();
    }
}
