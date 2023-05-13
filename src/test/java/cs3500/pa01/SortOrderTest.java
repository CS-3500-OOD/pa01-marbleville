package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortOrderTest {

  /**
   * Tests the getSortBy method for SortOrder
   */
  @Test
    public void testGetSortBy() {
      assertTrue(SortOrder.NAME.getSortBy() instanceof SortByName);
      assertTrue(SortOrder.CREATED.getSortBy() instanceof SortByCreated);
      assertTrue(SortOrder.LASTMODIFIED.getSortBy() instanceof SortByModified);
    }
}