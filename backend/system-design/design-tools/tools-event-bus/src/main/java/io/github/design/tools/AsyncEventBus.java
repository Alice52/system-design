package io.github.design.tools;

import java.util.concurrent.Executor;

/**
 * @author T04856 <br>
 * @create 2023-02-14 5:28 PM <br>
 * @project system-design <br>
 */
public class AsyncEventBus extends EventBus {

    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
