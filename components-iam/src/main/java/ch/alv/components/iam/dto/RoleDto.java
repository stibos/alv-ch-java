package ch.alv.components.iam.dto;

import ch.alv.components.web.dto.DtoImpl;

/**
 * WebApi dto for the {@link ch.alv.components.iam.model.Role} entity.
 *
 * @since 1.0.0
 */
public class RoleDto extends DtoImpl {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
