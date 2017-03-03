package com.kyyblabla.rpcframework.rpc;

import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * Created by kyy on 2017/3/3.
 */
public class ServiceRegistry {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcServer.class);


    public static class Constant {
        public static int ZK_SESSION_TIMEOUT = 5000;
        public static String ZK_REGISTRY_PATH = "/registry";
        public static String ZK_DATA_PATH = ZK_REGISTRY_PATH + "/data";
    }

    private CountDownLatch latch = new CountDownLatch(1);

    private String registryAddress;

    public ServiceRegistry(String registryAddress) {
        this.registryAddress = registryAddress;
    }

    public void register(String data) {
        if (data != null) {
            ZooKeeper zk = connectServer();
            if (zk != null) {
                createNode(zk, data);
            }
        }
    }

    private ZooKeeper connectServer() {
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper(registryAddress, Constant.ZK_SESSION_TIMEOUT, new Watcher() {
                public void process(WatchedEvent event) {
                    if (event.getState() == Event.KeeperState.SyncConnected) {
                        latch.countDown();
                    }
                }
            });
            latch.await();
        } catch (Exception e) {
            LOGGER.error("链接服务失败：", e);
        }
        return zk;
    }

    private void createNode(ZooKeeper zk, String data) {
        try {
            byte[] bytes = data.getBytes();
            String path = zk.create(Constant.ZK_DATA_PATH, bytes, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            LOGGER.info(String.format("create zookeeper node (%s => %s)", path, data));
        } catch (Exception e) {
            LOGGER.error("节点创建失败：", e);
        }
    }


}
