package cs3500.pa01;

public class MarkDownReader extends FileSystemReader<MarkDown> {
  SortByX sortBy;
  SortOrder sortOrder;

    public MarkDownReader(SortOrder sortBy, String path) {
      super(path);
      this.sortBy = sortBy.getSortBy();
    }
}
