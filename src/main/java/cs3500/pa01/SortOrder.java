package cs3500.pa01;

/**
 * Represents the different ways to sort the study guide.
 */
public enum SortOrder {
  NAME, CREATED, LASTMODIFIED, TEST;

  public SortByX getSortBy() {
    switch (this) {
      case NAME:
        return new SortByName();
      case CREATED:
        return new SortByCreated();
      case LASTMODIFIED:
        return new SortByModified();
      default:
        throw new IllegalArgumentException("Invalid SortOrder");
    }
  }

  public static SortOrder getSortOrder(String sortOrder) {
    switch (sortOrder) {
      case "n":
        return NAME;
      case "c":
        return CREATED;
      case "m":
        return LASTMODIFIED;
      default:
        throw new IllegalArgumentException("Invalid SortOrder");
    }
  }
}
