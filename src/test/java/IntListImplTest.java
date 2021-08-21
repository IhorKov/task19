import com.task.IntList;
import com.task.IntListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntListImplTest {

    IntList subject;

    @BeforeEach
    public void setUp() {
        subject = new IntListImpl();
    }

    @Test
    public void shouldBeNoElement() {

        int actual = subject.size();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeStoredUnderCorrectIndices() {
        subject.add(5);
        subject.add(3);

        int expected1 = 5;
        int expected2 = 3;
        int actual1 = subject.getByIndex(0);
        int actual2 = subject.getByIndex(1);

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    public void shouldMoveElements() {
        subject.add(5);
        subject.add(3);
        subject.add(7);

        subject.removeByIndex(1);

        int expected = 7;
        int actual = subject.getByIndex(1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowAnException() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            subject.getByIndex(11);
        });
        ;
    }

    @Test
    public void shouldReturnSublist() {
        subject.add(5);
        subject.add(3);
        subject.add(7);
        subject.add(2);
        subject.add(10);

        IntList actualList = subject.subList(1, 4);

        IntList expectedList = new IntListImpl();

        expectedList.add(3);
        expectedList.add(7);
        expectedList.add(2);
        expectedList.add(10);

        for (int i = 0; i < actualList.size(); i++) {
            Assertions.assertEquals(expectedList.getByIndex(i), actualList.getByIndex(i));
        }
    }

    @Test
    public void shouldReturnSize() {
        subject.add(5);
        subject.add(3);
        subject.add(7);
        subject.add(2);
        subject.add(10);
        subject.add(71);
        subject.add(37);

        int actual = subject.size();
        int expected = 7;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCapacity() {
        int actual = subject.capacity();
        int expected = 10;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPresenceOfElement() {
        subject.add(2);

        boolean actual1 = subject.contains(5);
        boolean actual2 = subject.contains(2);

        Assertions.assertEquals(false, actual1);
        Assertions.assertEquals(true, actual2);
    }

    @Test
    public void shouldNotChangeArray() {

        subject.add(5);
        subject.add(3);
        subject.add(7);
        subject.add(2);
        subject.add(10);
        subject.add(71);
        subject.add(37);

        int[] arr = subject.toArray();
        arr[3] = 100;

        Assertions.assertEquals(2, subject.getByIndex(3));
    }
}
