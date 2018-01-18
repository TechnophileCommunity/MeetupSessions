package techniphile.app.com.todomvp.utils;

/**
 * Created by moinkhan on 18-01-2018.
 */

public class StringUtils {

    public static boolean isNullOrEmpty(String str) {
        return str != null && str.trim().length() != 0;
    }

}
