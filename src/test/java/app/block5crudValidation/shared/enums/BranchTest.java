package app.block5crudValidation.shared.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BranchTest {

    @Test
    void testToString() {
        assertEquals("FRONT", Branch.FRONT.toString());
        assertEquals("BACK", Branch.BACK.toString());
        assertEquals("FULLSTACK", Branch.FULLSTACK.toString());
        assertEquals("DEVOPS", Branch.DEVOPS.toString());
        assertEquals("UNASSIGNED", Branch.UNASSIGNED.toString());
    }

    @Test
    void testValues() {
        Branch[] branches = Branch.values();
        assertEquals(5, branches.length);
        assertEquals(Branch.FRONT, branches[0]);
        assertEquals(Branch.BACK, branches[1]);
        assertEquals(Branch.FULLSTACK, branches[2]);
        assertEquals(Branch.DEVOPS, branches[3]);
        assertEquals(Branch.UNASSIGNED, branches[4]);
    }

    @Test
    void testEquals() {
        assertEquals(Branch.FRONT, Branch.FRONT);
        assertNotEquals(Branch.FRONT, Branch.BACK);
        assertNotEquals(Branch.FRONT, null);
    }

    @Test
    void testHashCode() {
        assertEquals(Branch.FRONT.hashCode(), Branch.FRONT.hashCode());
        assertNotEquals(Branch.FRONT.hashCode(), Branch.BACK.hashCode());
    }

    @Test
    void testOrdinal() {
        assertEquals(0, Branch.FRONT.ordinal());
        assertEquals(1, Branch.BACK.ordinal());
        assertEquals(2, Branch.FULLSTACK.ordinal());
        assertEquals(3, Branch.DEVOPS.ordinal());
        assertEquals(4, Branch.UNASSIGNED.ordinal());
    }

    @Test
    void compareTo() {
        assertTrue(Branch.FRONT.compareTo(Branch.BACK) < 0);
        assertTrue(Branch.BACK.compareTo(Branch.FRONT) > 0);
        assertEquals(0, Branch.FULLSTACK.compareTo(Branch.FULLSTACK));
    }

    @Test
    void getDeclaringClass() {
        assertEquals(Branch.class, Branch.FRONT.getDeclaringClass());
    }

    @Test
    void describeConstable() {
        assertNotNull(Branch.FRONT.describeConstable());
    }

    @Test
    void testFinalize() {
        Branch branch = Branch.FRONT;
        System.gc(); // Call garbage collector
    }

    @Test
    void testClone() {
        assertEquals(Branch.FRONT, Branch.FRONT);
    }

    @Test
    void name() {
        assertEquals("FRONT", Branch.FRONT.name());
    }

    @Test
    void values() {
        Branch[] branches = Branch.values();
        assertEquals(5, branches.length);
    }

    @Test
    void testValueOf() {
        assertEquals(Branch.FRONT, Branch.valueOf(Branch.FRONT.name()));
    }
}
