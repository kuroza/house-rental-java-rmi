import java.util.*;

public class ListingTitleComparator implements Comparator<ListingInterface> {
    public int compare(ListingInterface a1, ListingInterface a2) {
        try {
            return a1.getTitle().compareTo(a2.getTitle());
        } catch (Exception e) {
            return 0;
        }
    }
}
