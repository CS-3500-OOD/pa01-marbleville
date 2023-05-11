package cs3500.pa01;

public enum SortOrder {
    NAME, CREATED, LASTMODIFIED;

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
}
