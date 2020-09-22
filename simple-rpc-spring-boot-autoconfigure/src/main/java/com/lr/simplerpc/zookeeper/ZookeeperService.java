package com.lr.simplerpc.zookeeper;

import com.lr.simplerpc.common.constant.Constant;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author xu.shijie
 * @since 2020/9/16
 */
public class ZookeeperService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZookeeperService.class);

    ZookeeperProperties zookeeperProperties;

    public ZookeeperService(ZookeeperProperties zookeeperProperties) {
        this.zookeeperProperties = zookeeperProperties;
        System.out.println(zookeeperProperties.toString());
    }

    public ZooKeeper connectServer() {
        final CountDownLatch latch = new CountDownLatch(1);
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper(zookeeperProperties.getIpAddress(), Constant.ZK_SESSION_TIMEOUT, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getState() == Event.KeeperState.SyncConnected) {
                        latch.countDown();
                    }
                }
            });
            latch.await();
        } catch (IOException | InterruptedException e) {
            LOGGER.error("failed", e);
        }
        return zk;
    }
}
