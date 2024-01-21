package org.example;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class SimpleMethod implements IMethodFacade {
    private Method method;

    public SimpleMethod(Method method) {
        this.method = method;
    }

    @Override
    public boolean isPublic() {
        return Modifier.isPublic(method.getModifiers());
    }

    @Override
    public boolean paramsCountEquals(int n) {
        return method.getParameterCount()==n;
    }

    @Override
    public boolean startsWith(String prefix) {
        return method.getName().startsWith(prefix);
    }

    @Override
    public boolean isVoid() {
        return method.getReturnType().equals(void.class);
    }

    @Override
    public boolean isSetter() {
        return isPublic()&&paramsCountEquals(1)&&startsWith("set")&&isVoid();
    }

    @Override
    public boolean isGetter() {
        return isPublic()&&paramsCountEquals(0)&&(startsWith("get")||startsWith("is"))&&!isVoid();
    }

    @Override
    public String getFieldName() {
        if(!isGetter() && !isSetter())return null;
        if(startsWith("is")) return method.getName();
        return method.getName().substring(3).toLowerCase();
    }

    @Override
    public Method GetUnderlyingMethod() {
        return method;
    }


}
