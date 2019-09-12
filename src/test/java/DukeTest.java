import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DukeTest {
    Task TodoTest = new Todo("Todo test");
    Task DeadlineTest = new Deadline("Deadline test", "2/12/2019 1800");
    Task EventTest = new Event("Event test", "Monday 6pm");

    @Test
    public void dummyTest(){

        assertEquals(2, 2);
        assertEquals(TodoTest.toString(), "[T][\u2718] Todo test");
        assertEquals(DeadlineTest.toString(),"[D][\u2718] Deadline test (by: 2/12/2019 1800)");
        assertEquals(EventTest.toString(),"[E][\u2718] Event test (at: Monday 6pm)");
    }
}
