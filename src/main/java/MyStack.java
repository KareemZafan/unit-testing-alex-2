import java.util.ArrayList;
import java.util.List;

public class MyStack {
    private ArrayList<Integer> stackList;

    public MyStack() {
        stackList = new ArrayList<>();
    }

    public void push(int i) {
        stackList.add(i);
    }

    public int getSize() {
        return stackList.size();
    }

    public int getPeek() {
        if (isEmpty()) throw new IllegalStateException("Stack Is Empty!");
        return stackList.get(getSize() - 1);
    }

    public ArrayList<Integer> getCurrentStack() {
        return stackList;
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack Is Empty!");
        int itemToRemove = getPeek();
        stackList.remove(getSize() - 1);
        return itemToRemove;
    }
}
