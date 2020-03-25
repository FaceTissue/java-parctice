package com.guide.java.MultipleThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/***************************************************************************
 * @className: CyclicBarrier
 * @date     : 2020/1/14 11:22
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
//public class CyclicBarrier {
//    private static class Generation {
//        boolean broken = false;
//    }
//
//    private final ReentrantLock lock = new ReentrantLock();
//    private final Condition trip = lock.newCondition();
//    private final int parties;
//    private final Runnable barrierCommand;
//    private Generation generation = new Generation();
//
//    private int count;
//
//    private void nextGeneration() {
//        trip.signalAll();
//        count = parties;
//        generation = new Generation();
//    }
//
//    private void breakBarrier() {
//        generation.broken = true;
//        count = parties;
//        trip.signalAll();
//    }
//
//    private int dowait(boolean timed, long nanos)
//        throws InterruptedException, BrokenBarrierException,
//            TimeoutException {
//        final ReentrantLock lock = this.lock;
//        lock.lock();
//        try {
//            final Generation g = generation;
//            if (g.broken) {
//                throw new BrokenBarrierException();
//            }
//            if (Thread.interrupted()) {
//                breakBarrier();
//                throw new InterruptedException();
//            }
//            int index = --count;
//            if (index == 0) {
//                boolean ranAction = false;
//                try {
//                    final Runnable command = barrierCommand;
//                    if (command != null) {
//                        command.run();
//                    }
//                    ranAction = true;
//                    nextGeneration();
//                    return 0;
//                } finally {
//                    if (!ranAction) {
//                        breakBarrier();
//                    }
//                }
//            }
//
//            for (;;) {
//                try {
//                    if (!timed)
//                        trip.await();
//                    else if (nanos > 0L)
//                        nanos = trip.awaitNanos(nanos);
//                } catch (InterruptedException ie) {
//                    if (g == generation && ! g.broken) {
//                        breakBarrier();
//                        throw ie;
//                    } else {
//                        Thread.currentThread().interrupt();
//                    }
//                }
//                if (g.broken) {
//                    throw new BrokenBarrierException();
//                }
//
//                if (g != generation) {
//                    return index;
//                }
//
//                if (timed && nanos < 0L) {
//                    breakBarrier();
//                    throw new TimeoutException();
//                }
//            }
//        } finally {
//            lock.unlock();
//        }
//    }
//}
