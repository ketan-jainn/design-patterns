/** Iterator: sequential access without exposing internal structure. */
import java.util.Iterator;
import java.util.NoSuchElementException;

class BookShelf implements Iterable<String> {
    private final String[] books;
    private int size;

    BookShelf(int cap) {
        books = new String[cap];
    }

    void add(String title) {
        if (size < books.length) {
            books[size++] = title;
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int i;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return books[i++];
            }
        };
    }
}

public class IteratorDemo {
    public static void main(String[] args) {
        BookShelf shelf = new BookShelf(3);
        shelf.add("GoF");
        shelf.add("Effective Java");
        for (String b : shelf) {
            System.out.println(b);
        }
    }
}
