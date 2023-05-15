package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudyGuideGeneratorTest {
    StudyGuideGenerator sggName;
    StudyGuideGenerator sggCreated;
    StudyGuideGenerator sggModified;

    @BeforeEach
    public void setUp() {
        sggName = new StudyGuideGenerator("./src/test/resources",
            SortOrder.NAME,
            "./src/test/sggName.md");
        sggCreated = new StudyGuideGenerator("./src/test/resources",
            SortOrder.CREATED,
            "./src/test/sggCreated.md");
        sggModified = new StudyGuideGenerator("./src/test/resources",
            SortOrder.LASTMODIFIED,
            "./src/test/sggModified.md");
    }

    @Test
    public void testGenerateStudyGuide() {
        sggName.generateStudyGuide();
        sggCreated.generateStudyGuide();
        sggModified.generateStudyGuide();
        File modified = new File("src/test/sggModified.md");
        File name = new File("src/test/sggName.md");
        File created = new File("src/test/sggCreated.md");
        assertTrue(modified.exists());
        assertTrue(name.exists());
        assertTrue(created.exists());
        assertTrue(modified.delete());
        assertTrue(name.delete());
        assertTrue(created.delete());
    }

    @Test
    public void testNameText() {
        sggName.generateStudyGuide();
        StringBuilder sb = new StringBuilder();
        File name = new File("src/test/sggName.md");
        try {
            Scanner scanner = new Scanner(name);
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                sb.append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(sb.toString(), "# Java\n" +
            "- An **array** is a collection of variables of the same type\n" +
            "\n" +
            "## Declaring\n" +
            "- General Form: type[] arrayName;\n" +
            "- only creates a reference\n" +
            "- no array has\n" +
            "\n" +
            "## Creating\n" +
            "- General form:  arrayName = new type[numberOfElements];\n" +
            "- numberOfElements must be a positive Integer.\n" +
            "- Gotcha: Array size is not  modifiable once instantiated.\n" +
            "\n" +
            "# Vectors\n" +
            "- Vectors act like a resizable array\n" +
            "\n" +
            "## Declaring\n" +
            "- General Form: Vector<type> v = new Vector();\n" +
            "- type needs to be a valid reference type\n" +
            "\n" +
            "## Adding\n" +
            "- v.add(object of type);\n" +
            "\n");
        assertTrue(name.delete());
    }

    @Test
    public void testCreatedText() {
        sggCreated.generateStudyGuide();
        StringBuilder sb = new StringBuilder();
        File name = new File("src/test/sggCreated.md");
        try {
            Scanner scanner = new Scanner(name);
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                sb.append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(sb.toString(), "# Java\n" +
            "- An **array** is a collection of variables of the same type\n" +
            "\n" +
            "## Declaring\n" +
            "- General Form: type[] arrayName;\n" +
            "- only creates a reference\n" +
            "- no array has\n" +
            "\n" +
            "## Creating\n" +
            "- General form:  arrayName = new type[numberOfElements];\n" +
            "- numberOfElements must be a positive Integer.\n" +
            "- Gotcha: Array size is not  modifiable once instantiated.\n" +
            "\n" +
            "# Vectors\n" +
            "- Vectors act like a resizable array\n" +
            "\n" +
            "## Declaring\n" +
            "- General Form: Vector<type> v = new Vector();\n" +
            "- type needs to be a valid reference type\n" +
            "\n" +
            "## Adding\n" +
            "- v.add(object of type);\n" +
            "\n");
        assertTrue(name.delete());
    }

    @Test
    public void testModifiedText() {
        sggModified.generateStudyGuide();
        StringBuilder sb = new StringBuilder();
        File name = new File("src/test/sggModified.md");
        try {
            Scanner scanner = new Scanner(name);
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                sb.append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(sb.toString(), "# Vectors\n" +
            "- Vectors act like a resizable array\n" +
            "\n" +
            "## Declaring\n" +
            "- General Form: Vector<type> v = new Vector();\n" +
            "- type needs to be a valid reference type\n" +
            "\n" +
            "## Adding\n" +
            "- v.add(object of type);\n" +
            "\n" +
            "# Java\n" +
            "- An **array** is a collection of variables of the same type\n" +
            "\n" +
            "## Declaring\n" +
            "- General Form: type[] arrayName;\n" +
            "- only creates a reference\n" +
            "- no array has\n" +
            "\n" +
            "## Creating\n" +
            "- General form:  arrayName = new type[numberOfElements];\n" +
            "- numberOfElements must be a positive Integer.\n" +
            "- Gotcha: Array size is not  modifiable once instantiated.\n" +
            "\n");
        assertTrue(name.delete());
    }
}