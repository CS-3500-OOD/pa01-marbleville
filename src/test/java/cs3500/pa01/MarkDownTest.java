package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.attribute.FileTime;
import java.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MarkDownTest {

  MarkDown md;
  @BeforeEach
  public void setUp() {
    md = new MarkDown("Test", FileTime.from(Instant.EPOCH),
        FileTime.from(Instant.EPOCH));
  }

  /**
   * Tests the constructor for MarkDown
   */
  @Test
  public void testConstructor() {
    assertEquals("Test", md.getName());
    assertEquals(FileTime.from(Instant.EPOCH), md.getCreated());
    assertEquals(FileTime.from(Instant.EPOCH), md.getLastModified());
  }

  /**
   * Tests the addMDUnit and toString method for MarkDown
   */
  @Test
  public void testToString() {
    assertEquals("", md.toString());
    md.addMDUnit(new MarkDownUnit("Test", "#"));
    assertEquals("# Test\n\n", md.toString());
    md.addMDUnit(new MarkDownUnit("Test1", "[["));
    assertEquals("# Test\n\n- Test1\n", md.toString());
  }

  /**
   * Tests the tokenizeLine method for MarkDown
   */
  @Test
  public void testTokenizeLine() {
    md.tokenizeLine("# Test");
    assertEquals("# Test\n\n", md.toString());
    md.tokenizeLine("[[Test1]]");
    assertEquals("# Test\n\n- Test1\n", md.toString());
    md.tokenizeLine("[[Test2]]");
    assertEquals("# Test\n\n- Test1\n- Test2\n", md.toString());
  }

}