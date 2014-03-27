package ch.alv.components.iam.search;

import ch.alv.components.iam.IamConstant;
import ch.alv.components.persistence.search.BaseSearchParamValuesProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link ch.alv.components.persistence.repository.ParamValuesProvider} for {@link ch.alv.components.iam.model.Role} entities.
 *
 * @since 1.0.0
 */
public class RoleSearchParamValuesProvider extends BaseSearchParamValuesProvider {

    @Override
    public Map<String, Object> getParams() {
        Map<String, Object> map = new HashMap<>();
        map.put(IamConstant.PARAM_NAME, getStringValue("name"));
        return map;
    }

}
