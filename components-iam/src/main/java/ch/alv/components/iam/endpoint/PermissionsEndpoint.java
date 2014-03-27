package ch.alv.components.iam.endpoint;

import ch.alv.components.core.model.ModelItem;
import ch.alv.components.iam.endpoint.dto.PermissionDto;
import ch.alv.components.iam.model.Permission;
import ch.alv.components.web.dto.Dto;
import ch.alv.components.web.endpoint.Endpoint;
import ch.alv.components.web.endpoint.EndpointHelper;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Endpoint for permission entities of the iam module.
 *
 * @since 1.0.0
 */
@Component
public class PermissionsEndpoint implements Endpoint {

    @Override
    public String getModuleName() {
        return "iam";
    }

    @Override
    public String getStoreName() {
        return "permissions";
    }

    @Override
    public Class<? extends Dto> getDtoClass() {
        return PermissionDto.class;
    }

    @Override
    public Class<? extends ModelItem> getEntityClass() {
        return Permission.class;
    }

    @Override
    public List<HttpMethod> getAllowedMethods() {
        return EndpointHelper.createAllMethodsList();
    }

    @Override
    public String getServiceName() {
        return "iam.permission";
    }

    @Override
    public String getRolesGET() {
        return "";
    }

    @Override
    public String getRolesPOST() {
        return "";
    }

    @Override
    public String getRolesPUT() {
        return "";
    }

    @Override
    public String getRolesDELETE() {
        return "";
    }

}
