package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CartManagerTestNonEmptiWithSetup {
    CartManager manager = new CartManager();
    PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
    PurchaseItem second = new PurchaseItem(2, 1, "second", 1,1);
    PurchaseItem third = new PurchaseItem(3, 1, "third", 1,1);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldRemoveIfExist() {
        int idToRemove = 1;
        manager.removeById(idToRemove);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[] {third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExist() {
        int idToRemove = 4;
        manager.removeById(idToRemove);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[] {third, second, first};
        assertArrayEquals(expected, actual);
    }
}
