package thread.create.implement.callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {

    @Override
    public Integer call() throws Exception {
        return 110;
    }

}
