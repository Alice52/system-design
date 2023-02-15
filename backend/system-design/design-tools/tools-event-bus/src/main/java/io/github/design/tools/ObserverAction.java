package io.github.design.tools;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author T04856 <br>
 * @create 2023-02-14 4:06 PM <br>
 * @project system-design <br>
 */
@Slf4j
@Data
public class ObserverAction {
    private Object target;
    private Method method;

    public ObserverAction(Object target, Method method) {
        this.target = Objects.requireNonNull(target);
        this.method = method;
        this.method.setAccessible(true);
    }

    public void execute(Object event) {
        try {
            method.invoke(target, event);
        } catch (InvocationTargetException | IllegalAccessException e) {
            log.error("execute failed: ", e);
        }
    }
}
