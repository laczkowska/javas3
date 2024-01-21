package org.example;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Stream;

public class SimpleClass implements IClassFacade {
    private Class<?> clazz;

    public SimpleClass(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public List<IMethodFacade> getPublicDeclaredMethods() {
        return Stream.of(clazz.getDeclaredMethods())
                .map(method->(IMethodFacade)new SimpleMethod(method))
                .filter(method-> method.isPublic())
                .toList();
    }

    @Override
    public List<IMethodFacade> getPublicGetters() {
        return getPublicDeclaredMethods().stream()
                .filter(m->m.isGetter())
                .toList();
    }

    @Override
    public List<IMethodFacade> getPublicSetters() {
        return getPublicDeclaredMethods().stream()
                .filter(m-> m.isSetter())
                .toList();
    }

    @Override
    public List<Field> getFieldsForPublicProperties() {

        var getterNames = getPublicGetters().stream()
                .map(x->x.getFieldName().toLowerCase())
                .toList();
        var propertiesNames = getPublicSetters().stream()
                .map(x->x.getFieldName().toLowerCase())
                .filter(name->getterNames.contains(name))
                .distinct()
                .toList();

        return Stream.of(clazz.getDeclaredFields())
                .filter(field->propertiesNames
                        .contains(field.getName().toLowerCase()))
                .toList();
    }
}
