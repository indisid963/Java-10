package Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testMatchesSimpleTaskTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Сообщить о новой задаче");

        boolean actual = simpleTask.matches("ново");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesSimpleTaskFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Сообщить о новой задаче");

        boolean actual = simpleTask.matches("сотруднику");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesEpicTrue() {
        Epic epic = new Epic(5, new String[]{"сделка", "договор", "расторжение"});

        boolean actual = epic.matches("договор");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesEpicFalse() {
        Epic epic = new Epic(5, new String[]{"сделка", "договор", "расторжение"});

        boolean actual = epic.matches("заключение");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesMeetingTopicTrue() {
        Meeting meeting = new Meeting(55, "Заключение договора", "ООО_Крылатые качели", "Во вторник после обеда");

        boolean actual = meeting.matches("договор");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesMeetingTopicFalse() {
        Meeting meeting = new Meeting(55, "Заключение договора", "ООО_Крылатые качели", "Во вторник после обеда");

        boolean actual = meeting.matches("контракт");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesMeetingProjectTrue() {
        Meeting meeting = new Meeting(55, "Заключение договора", "ООО_Крылатые качели", "Во вторник после обеда");

        boolean actual = meeting.matches("качели");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesMeetingProjectFalse() {
        Meeting meeting = new Meeting(55, "Заключение договора", "ООО_Крылатые качели", "Во вторник после обеда");

        boolean actual = meeting.matches("старт");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }
}