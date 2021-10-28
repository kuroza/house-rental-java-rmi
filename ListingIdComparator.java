import java.util.*;

public class ListingIdComparator implements Comparator<Listing> {
    public int compare(Listing a1, Listing a2) {
        return a1.getId() - a2.getId();
    }
}
