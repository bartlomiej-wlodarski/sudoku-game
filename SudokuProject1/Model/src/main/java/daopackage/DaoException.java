package daopackage;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 *
 * @author Maciej
 */
class DaoException extends RuntimeException {
    
    //private static final ResourceBundle messages;
    public static final String NULL_NAME = "null.name";

    static {
        //Locale locale = Locale.getDefault(Locale.Category.DISPLAY);
        //messages = ResourceBundle.getBundle("exceptions.Dao", locale);
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    /*@Override
    public String getLocalizedMessage() {
        String message;
        try {
            message = "dao exception";//messages.getString(getMessage());
        } catch (MissingResourceException mre) {
            message = "No resource for " + getMessage() + "key";
        }
        return message;
    }*/
}
