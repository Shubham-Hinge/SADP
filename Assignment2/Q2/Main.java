import java.util.*;

class EnumerationIteratorAdapter implements Iterator<String> {
    private Enumeration<String> enumeration;

    public EnumerationIteratorAdapter(Enumeration<String> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public String next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported.");
    }
}

public class Main {
    public static void main(String[] args) {

    
        Vector<String> names = new Vector<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        Enumeration<String> enumeration = names.elements();

        Iterator<String> iterator = new EnumerationIteratorAdapter(enumeration);

        System.out.println("Elements using Iterator:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}