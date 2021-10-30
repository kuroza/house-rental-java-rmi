import java.util.*;

public class ListingIdComparator implements Comparator<ListingInterface> {
    public int compare(ListingInterface a1, ListingInterface a2) {
        try {
            return a1.getId() - a2.getId();
        } catch (Exception e) {
            return 0;
        }
    }
}
