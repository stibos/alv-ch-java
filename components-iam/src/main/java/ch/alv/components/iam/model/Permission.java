package ch.alv.components.iam.model;

import ch.alv.components.persistence.model.BaseJpaModelItem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Permission entity (works with table 'am_iam_permission')
 *
 * @since 1.0.0
 */
@Entity
@Table(name = "am_iam_permission")
public class Permission extends BaseJpaModelItem {

    @Column(nullable = false)
    private String name;

    @Column(name = "permission_key", nullable = false)
    private String key;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
