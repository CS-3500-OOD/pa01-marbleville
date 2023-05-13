package cs3500.pa01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Coordinates the generation of a study guide
 */
public class StudyGuideGenerator {
    MarkDown studyGuide;
    MarkDownReader markDownReader;

    Path inputPath;
    Writer fileWriter;

    public StudyGuideGenerator(String inputPath, SortOrder sortBy, String outputPath) {
        this.markDownReader = new MarkDownReader(sortBy, inputPath);
        this.inputPath = Path.of(inputPath);
        this.fileWriter = new Writer(outputPath);
    }

    public void generateStudyGuide() {
        try {
            Files.walkFileTree(inputPath, markDownReader);
        } catch (IOException e) {
            System.out.println("An error occurred walking the file tree.");
            e.printStackTrace();
        }
        studyGuide = markDownReader.toSingleMarkDown();
        this.fileWriter.writeFile(this.studyGuide);
    }

}
