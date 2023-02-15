package io.github.design.tools.test;

import io.github.design.tools.EventBus;

import java.util.List;

/**
 * @author T04856 <br>
 * @create 2023-02-15 8:49 AM <br>
 * @project system-design <br>
 */
public class UserService {
    private EventBus eventBus = new EventBus();

    /**
     * 添加观察者.
     *
     * @param observers
     */
    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    /**
     * 注册用户，触发动作。
     *
     * @param phone
     * @param password
     */
    public Long action(String phone, String password) {
        Long userId = 1L;

        eventBus.post(userId);

        return userId;
    }
}
