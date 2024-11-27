package blevi.autoszerviz.controller.wrappers;

import java.util.List;

public interface Filterable<T> {
    public List<T> getFilteredData(T t);
}
