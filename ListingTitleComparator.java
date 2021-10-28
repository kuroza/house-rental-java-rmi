import java.util.*;

public class ListingTitleComparator implements Comparator<Listing> {
    public int compare(Listing a1, Listing a2) {
        return a1.getTitle().compareTo(a2.getTitle());
    }
}
