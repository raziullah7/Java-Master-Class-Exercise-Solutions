import java.util.ArrayList;
import java.util.List;

// using '&' to use multiple upperbounds
public class QueryList<T extends Student & QueryItem> {
    private List<T> items;

    public QueryList(List<T> items) {
        this.items = items;
    }

    // this a class specific method
    public List<T> getMatches(String field, String value) {
        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }

    // this a static class non-specific method
    // you just need to pass the list as a parameter
    // the upperbound for the generics is set as QueryItem, so that
    // the method can be invoked on QueryItem, or it's super classes
    public static <T extends QueryItem> List<T> getMatches(List<T> items, String field, String value) {
        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}
