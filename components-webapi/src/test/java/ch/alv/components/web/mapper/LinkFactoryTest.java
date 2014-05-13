package ch.alv.components.web.mapper;

import ch.alv.components.web.context.ServletRequestProvider;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.hateoas.Link;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test cases for the {@link ch.alv.components.web.endpoint.EndpointRegistry} class.
 *
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/mapper-factories-tests.xml")
public class LinkFactoryTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Resource
    private LinkFactory factory;

    @Resource
    private ServletRequestProvider requestProvider;

    @Test
    public void test() {

        ((MockHttpServletRequest) requestProvider.getRequest()).setRequestURI("/api/test/test");

        UUID id = UUID.randomUUID();
        MockFactoryTestEntity entity = new MockFactoryTestEntity();
        entity.setId(id.toString());

        Link link = (Link) factory.createBean(entity, MockFactoryTestEntity.class, null);
        assertEquals("self", link.getRel());
        assertEquals("http://127.0.0.1:80/mapperFactoryModule/mapperFactoryModule/" + id.toString(), link.getHref());

        assertNull(factory.createBean(entity, ServletRequestProvider.class, null));
    }

}