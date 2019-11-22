package services.videa.web.blog.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampUtils {

    public static String timestamp(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
