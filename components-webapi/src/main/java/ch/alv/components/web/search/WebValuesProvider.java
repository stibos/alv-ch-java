package ch.alv.components.web.search;

import ch.alv.components.core.search.ValuesProvider;

import java.util.Map;

/**
 * {@link ch.alv.components.core.search.ValuesProvider} which takes a WebRequest param-map as source.
 *
 * @since 1.0.0
 */
public interface WebValuesProvider extends ValuesProvider {

    void setSource(Map<String, String[]> params);

}
