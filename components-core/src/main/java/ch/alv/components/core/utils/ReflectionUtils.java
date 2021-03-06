package ch.alv.components.core.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.ParameterizedType;

/**
 * Utility class for reflection concerns
 *
 * @since 1.0.0
 */
@SuppressWarnings("unchecked")
public class ReflectionUtils {

    private final static Log LOG = LogFactory.getLog(ReflectionUtils.class);

    /**
     * Determines the Type Parameter of the superclass of the particular class instance.
     * This method assumes that the class extends a parameterized Superclass which is not a raw-type and defines
     * the actual type parameters.
     *
     * @return The first type parameter for the particular class
     */
    public static <T> Class<T> determineFirstGenericParam(Class<?> classUnderExamination)  {
        return determineGenericParam(classUnderExamination, 0);
    }

    /**
     * Determines the Type Parameter of the superclass of the particular class instance.
     * This method assumes that the class extends a parameterized Superclass which is not a raw-type and defines
     * the actual type parameters.
     *
     * @return The type parameter with the given index for the particular class
     */
    public static <T> Class<T> determineGenericParam(Class<?> classUnderExamination, int index) {
        if (index < 0) {
            throw new ReflectionUtilsException("Param 'index' must not be lower than 0!");
        }
        if (classUnderExamination == null) {
            throw new ReflectionUtilsException("Param 'classUnderExamination' must not be null!");
        }
        if (classUnderExamination == Class.class) {
            throw new ReflectionUtilsException("Can't resolve a parameter class on type Class.class");
        }
        if (!(classUnderExamination.getGenericSuperclass() instanceof ParameterizedType)) {
            throw new ReflectionUtilsException("Class: " + classUnderExamination.getName() + " must extend a parameterized superclass...)");
        }

        ParameterizedType type = (ParameterizedType) classUnderExamination.getGenericSuperclass();
        if (index > type.getActualTypeArguments().length - 1) {
            throw new ReflectionUtilsException("No Type Parameter defined for: '" + type + "' with index '" + index + "'");
        }
        return (Class<T>) type.getActualTypeArguments()[index];
    }

    public static <T> T newInstanceQuietly(Class<T> targetClass) {
        try {
            return targetClass.newInstance();
        } catch (Exception e) {
            LOG.warn("Error while creating a new object of class " + targetClass.getName(), e);
            return null;
        }
    }

}
