package com.demo.pattern.test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author huaihai.guan
 * @since 2021/4/28 15:28
 */
public class FunFairLock extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int acquires) {
        Thread thread = Thread.currentThread();
        int state = getState();
        if (state == 0) {
            if (!hasQueuedPredecessors() && compareAndSetState(0, acquires)) {
                setExclusiveOwnerThread(thread);
                return true;
            }
            return false;
        } else {
            if (getExclusiveOwnerThread() == Thread.currentThread()) {
                setState(state + acquires);
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        int state = getState();
        if (state > 0 && Thread.currentThread() == getExclusiveOwnerThread()) {
            state = state - arg;
        } else {
            return false;
        }
        setState(state);
        return true;
    }

    public void lock() {
        acquire(1);
    }

    public void unlock() {
        release(0);
    }

}
