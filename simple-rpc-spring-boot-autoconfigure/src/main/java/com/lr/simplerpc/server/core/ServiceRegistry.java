package com.lr.simplerpc.server.core;

import com.lr.simplerpc.common.constant.Constant;
import com.lr.simplerpc.zookeeper.ZookeeperService;
import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @author xu.shijie
 * @since 2020/9/18
 */
@Component
public class ServiceRegistry {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceRegistry.class);

    final ZookeeperService zookeeperService;

    public ServiceRegistry( ZookeeperService zookeeperService) {
        this.zookeeperService = zookeeperService;
    }

    public void register(String data) {
        if (data != null && !"".equals(data)) {
            ZooKeeper zk = zookeeperService.connectServer();
            if (zk != null) {
                createNode(zk, data);
            }
        }
    }

    private void createNode(ZooKeeper zk, String data) {
        try{
            byte[] bytes = data.getBytes();
            String path = zk.create(Constant.ZK_DATA_PATH,bytes, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            LOGGER.debug("create zookeeper node ({} => {})", path, data);
        }catch (KeeperException | InterruptedException e){
            LOGGER.error("fail to create zookeeper node", e);
        }
    }
}
