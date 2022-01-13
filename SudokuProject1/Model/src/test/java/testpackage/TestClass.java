package testpackage;

import com.mycompany.sudokuproject1.Observer;
import com.mycompany.sudokuproject1.SudokuElement;

/**
 *
 * @author Maciej
 */
public class TestClass extends SudokuElement implements Observer {
    
    private boolean bool;
    
    public TestClass() {
        bool = false;
    }
    
    public boolean getBool() {
        return bool;
    }

    @Override
    public void update() {
        bool = !bool;
    }
    
}
