package cs3500.pa01;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;

/**
 * A class that reads in a file system and creates a list of MarkDown files.
 */
public class MarkDownReader extends FileSystemReader {
    private SortByX sortBy;
    private SortOrder sortOrder;

    public MarkDownReader(SortOrder sortBy, String path) {
        this.sortBy = sortBy.getSortBy();
    }


    @Override
    public FileVisitResult visitFile(Path filePath, BasicFileAttributes attr) {
        if (attr.isRegularFile() && filePath.toString().endsWith(".md")) {
            this.readFile(filePath, attr);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public void readFile(Path filePath, BasicFileAttributes attr) {
        String[] pathArr = filePath.toString().split("/");
        String fileName = pathArr[pathArr.length - 1];
        MarkDown md = new MarkDown(fileName, attr.creationTime(), attr.lastModifiedTime());
        this.addFile(md);
    }

    /**
     * Converts the list of MarkDown files into a single MarkDown file.
     *
     * @return a single MarkDown file
     */
    public MarkDown toSingleMarkDown() {
        MarkDown md =
            new MarkDown("studyGuide",
                FileTime.from(Instant.now()),
                FileTime.from(Instant.now()));
        for (FileType file : this.getFiles()) {
            for (FileUnit unit : file.getUnits()) {
                md.addMDUnit(unit);
            }
        }
        return md;
    }
}
