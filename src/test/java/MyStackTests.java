import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTests {
    private MyStack myStack;

    @BeforeEach
    void setUp(){
        myStack = new MyStack();
    }

    @Test
    void testPush(){
        myStack.push(1);
        myStack.push(2);
        myStack.push(100);

        assertEquals(3,myStack.getSize());
        assertEquals(100,myStack.getPeek());
        assertEquals(List.of(1,2,100),myStack.getCurrentStack());
    }

    @Test
    void testPop(){
        myStack.push(1);
        myStack.push(2);
        myStack.push(100);
        myStack.push(510);
        myStack.push(2000);

        int poppedItem = myStack.pop();
        assertEquals(2000,poppedItem);
        assertEquals(4,myStack.getSize());
        assertEquals(510,myStack.getPeek());
        assertEquals(List.of(1,2,100,510),myStack.getCurrentStack());
    }

    @Test
    void testPeekItem() {
        IllegalStateException ex = assertThrowsExactly(IllegalStateException.class, ()-> myStack.getPeek());
        assertTrue(ex.getMessage().contains("Stack Is Empty!"));

        myStack.push(1);
        myStack.push(2);
        myStack.push(100);
        myStack.push(510);
        myStack.push(2000);

        assertEquals(5, myStack.getSize());
        assertEquals(2000, myStack.getPeek());
        assertEquals(List.of(1, 2, 100, 510,2000), myStack.getCurrentStack());
    }

}
