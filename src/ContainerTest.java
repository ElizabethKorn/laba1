
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class ContainerTest {

    @Test
    void testAdd() {
        Container<String> container=new Container<>();
        container.add("Cat");
        container.add("Dog");

        assertEquals(2,container.size());

        assertEquals("Cat",container.get(0));
        assertEquals("Dog",container.get(1));
    }

    @Test
    void testGet() {
        Container<Integer> container=new Container<>();
        container.add(55);
        container.add(3);

        assertEquals(Integer.valueOf(55), container.get(0));
        assertEquals(Integer.valueOf(3), container.get(1));
    }

    @Test
    void testRemove() {
        Container<String> container=new Container<>();
        container.add("Cat");
        container.add("Dog");
        container.add("Pig");

        assertEquals(3,container.size());

        String remEl=container.remove(1);
        assertEquals("Dog",remEl);

        assertEquals(2,container.size());
        assertEquals("Pig",container.get(1));
    }

    @Test
    void testSize() {
        Container<String> container=new Container<>();
        container.add("Cat");
        container.add("Dog");
        container.add("Pig");

        assertEquals(3,container.size());

        container.remove(1);

        assertEquals(2,container.size());

    }

    @Test
    void testToString() {
        Container<String> container=new Container<>();
        container.add("Cat");
        container.add("Dog");
        container.add("Pig");
        String expected="Cat, Dog, Pig";
        assertEquals(expected, container.toString());
    }

    @Test
    void testEquals() {
        Container<String> container1=new Container<>();
        container1.add("Cat");
        container1.add("Dog");
        container1.add("Pig");

        Container<String> container2=new Container<>();
        container2.add("Cat");
        container2.add("Dog");
        container2.add("Pig");

        assertEquals(container1, container2);

    }
}