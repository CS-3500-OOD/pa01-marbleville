package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.attribute.FileTime;
import java.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileTypeTest {
  FileType ft;
  long l1 = 10000000L;

  @BeforeEach
  public void setUp() {
    long l1 = 10000000L;
    ft = new MarkDown("test.txt",
        FileTime.from(Instant.ofEpochMilli(l1)), FileTime.from(Instant.ofEpochMilli(l1)));
  }

  /**
   * Tests the getName method for FileType
   */
  @Test
  public void testGetName() {
    assertEquals("test.txt", ft.getName());
  }

  /**
   * Tests the getCreated method for FileType
   */
  @Test
  public void testGetCreated() {
    assertEquals(FileTime.from(Instant.ofEpochMilli(l1)), ft.getCreated());
  }

  /**
   * Tests the getLastModified method for FileType
   */
  @Test
  public void testGetLastModified() {
    assertEquals(FileTime.from(Instant.ofEpochMilli(l1)), ft.getLastModified());
  }
}