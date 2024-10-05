package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestExample {
    private ToDo toDo;

    @BeforeEach
    public void setUp() {
        toDo = new ToDo();
    }

    @Test
    public void testAddItemWithoutImportance() {
        toDo.addItem("Buy groceries");
        Assertions.assertEquals(1, toDo.getListSize());
        Assertions.assertEquals("Buy groceries", toDo.getItem(0).getTask());
        Assertions.assertEquals("Medium", toDo.getItem(0).getImportance()); // Assuming default importance is Medium
    }

    @Test
    public void testAddItemWithImportance() {
        toDo.addItem( "Complete homework","High");
        Assertions.assertEquals(1, toDo.getListSize());
        Assertions.assertEquals("Complete homework", toDo.getItem(0).getTask());
        Assertions.assertEquals("High", toDo.getItem(0).getImportance());
    }

    @Test
    public void testFinishItem() {
        toDo.addItem("Read a book");
        toDo.addItem("Write code");
        Assertions.assertEquals(2, toDo.getListSize());

        Item itemToFinish = toDo.getItem(0);
        toDo.finishItem(itemToFinish);

        Assertions.assertEquals(1, toDo.getListSize());
        Assertions.assertEquals("Write code", toDo.getItem(0).getTask());
    }

    @Test
    public void testGetListEmpty() {
        // Test if the list is empty
        Assertions.assertEquals(0, toDo.getListSize());
    }
}
