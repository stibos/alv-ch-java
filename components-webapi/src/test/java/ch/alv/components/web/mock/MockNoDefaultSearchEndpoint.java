package ch.alv.components.web.mock;

import ch.alv.components.core.beans.ModelItem;
import ch.alv.components.web.dto.Dto;
import ch.alv.components.web.endpoint.DefaultEndpoint;
import org.springframework.stereotype.Component;

/**
 * Mocked endpoint for unit tests.
 *
 * @since 1.0.0
 */
@Component
public class MockNoDefaultSearchEndpoint extends DefaultEndpoint {
    @Override
    public String getModuleName() {
        return "noDefaultSearchModule";
    }

    @Override
    public String getStoreName() {
        return "noDefaultSearchStore";
    }

    @Override
    public Class<? extends Dto> getDtoClass() {
        return MockDto.class;
    }

    @Override
    public Class<? extends ModelItem> getEntityClass() {
        return MockEntity.class;
    }

}
