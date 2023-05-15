package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MarkDownReaderTest {
  MarkDownReader mdr;

  @BeforeEach
  void setUp() {
    mdr = new MarkDownReader(SortOrder.NAME);
  }

  /**
   * Tests that the visitFile and readFile methods work as expected.
   */
  @Test
  void testVisitFile() {
    boolean readSuccess = true;
    // Tests an existing file
    try {
      BasicFileAttributes attr = Files.readAttributes(
          Paths.get("src/test/resources/arrays.md"), BasicFileAttributes.class);
      mdr.visitFile(Path.of("src/test/resources/arrays.md"), attr);
    } catch (IOException e) {
      readSuccess = false;
    }
    assertTrue(readSuccess);
    assertEquals("arrays.md", mdr.getFiles().get(0).getName());
    assertEquals(10, mdr.getFiles().get(0).getUnits().size());

    // Tests a non-existing file
    boolean readSuccess2 = true;
    try {
      BasicFileAttributes attr = Files.readAttributes(
          Paths.get("src/test/resources/arrays2.md"), BasicFileAttributes.class);
      mdr.visitFile(Path.of("src/test/resources/arrays2.md"), attr);
    } catch (IOException e) {
      readSuccess2 = false;
    }
    assertFalse(readSuccess2);
  }

  @Test
  public void testToSingleMarkDown() {
    // Test on empty MDR
    assertEquals("studyGuide", mdr.toSingleMarkDown().getName());
    assertEquals(0, mdr.toSingleMarkDown().getUnits().size());

    // Test on non-empty MDR
    boolean walkSuccess = true;
    try {
      Files.walkFileTree(Path.of("src/test/resources"), mdr);
      mdr.toSingleMarkDown();
    } catch (IOException e) {
      walkSuccess = false;
    }
    assertEquals("studyGuide", mdr.toSingleMarkDown().getName());
    assertEquals(17, mdr.toSingleMarkDown().getUnits().size());
    assertTrue(walkSuccess);
  }
}