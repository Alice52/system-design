package io.github.design.tools.test;

import io.github.design.tools.annotation.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author T04856 <br>
 * @create 2023-02-15 8:47 AM <br>
 * @project system-design <br>
 */
@Slf4j
public class Observer {
    @Subscribe
    public void handleRegSuccess(Long userId) {
        log.info("DemoObserver01" + "给注册用户" + userId + "发放优惠券");
    }

    @Subscribe
    public void handleRegSuccess(Entity name) {
        log.info("DemoObserver01" + "给注册用户" + name + "发放优惠券" + "DemoAbstractEntity");
    }
}
