package tests;

import com.mycompany.test.Application;
import com.mycompany.test.Binder;
import com.mycompany.test.Document;
import com.mycompany.test.Excuse;
import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Maciej
 */
public class BinderTest {
    
    public BinderTest() {
    }
    
    @Test
    public void CreateBinderTest() {
        Binder binder = new Binder(4);
        Excuse ex1 = new Excuse(1, LocalDate.of(2004, 03, 03));
        Excuse ex2 = new Excuse(2, LocalDate.of(2001, 03, 03));
        Application ap1 = new Application(3, LocalDate.of(2007, 03, 03));
        Application ap2 = new Application(4, LocalDate.of(2009, 03, 03));
        binder.put(ex1);
        binder.put(ex2);
        binder.put(ap1);
        binder.put(ap2);
        assertEquals(binder.getFreeSpace(), 0);
    }
}
