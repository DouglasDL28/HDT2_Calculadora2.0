import java.util.Vector;

public class Pila<String> implements iPila<String> {

    private Vector<String> data;

    public Pila () {
        this.data = new Vector<>();
    }

    @Override
    public boolean empty() {
        return (data.size() == 0);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public String peek() {
        return data.get(0);
    }

    @Override
    public String pop() {
            return data.remove(0);
    }

    @Override
    public void push(String item) {
        data.add(item);
    }

    @Override
    public java.lang.String toString() {

        java.lang.String result = "";
        for (String i: data) {
            result = result + i;
        }

        return result;
    }
}
