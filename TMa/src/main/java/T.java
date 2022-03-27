import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

public class T {

    private static TrackerClient trackerClient = null;
    private static TrackerServer trackerServer = null;
    private static StorageServer storageServer = null;
    private static StorageClient storageClient = null;


    public static void main(String[] args) {
            delete();
    }

    public static void update() {
        try {
//            读取配置
            ClientGlobal.init("fdfs_client.conf");
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageServer = trackerClient.getStoreStorage(trackerServer);
//            用这个对象完成上传下载删除操作
            storageClient = new StorageClient(trackerServer, storageServer);
            /**
             * 参数1 为需要上传的文件的绝对路径
             * 参数2 为需要的上传的文件的拓展名
             * 参数3 文件的属性 通常不上传
             */
            String[] strings = storageClient.upload_file("E:\\25.jpg", "jpg", null);
            for (String str : strings){
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }finally {
            try {
                storageServer.close();
                trackerServer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void download() {
        try {
//            读取配置
            ClientGlobal.init("fdfs_client.conf");
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageServer = trackerClient.getStoreStorage(trackerServer);
//            用这个对象完成上传下载删除操作
            storageClient = new StorageClient(trackerServer, storageServer);

            /**
             *  文件下载
             *  返回值 0 表示文件下载成功
             * 参数1 需要文件组名
             * 参数2 需要下载的远程文件名
             * 参数3 需要保存的本地文件名
             *
             */
            String groupName = "group1";
            String remoteFilename = "M00/00/00/rBQmxmI_UDyALh21AACG4UPE48k799.jpg";
            String localFilename = "D:/aa.jpg";
            System.out.println(storageClient.download_file(groupName, remoteFilename, localFilename));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }finally {
            try {
                storageServer.close();
                trackerServer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void delete() {
        try {
//            读取配置
            ClientGlobal.init("fdfs_client.conf");
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageServer = trackerClient.getStoreStorage(trackerServer);
//            用这个对象完成上传下载删除操作
            storageClient = new StorageClient(trackerServer, storageServer);

            /**
             *  文件删除
             *  返回值 0 表示文件下载成功
             * 参数1 需要文件组名
             * 参数2 需要下载的远程文件名
             *
             */
            String groupName = "group1";
            String remoteFilename = "M00/00/00/rBQmxmI_UDyALh21AACG4UPE48k799.jpg";
            System.out.println(storageClient.delete_file(groupName, remoteFilename));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }finally {
            try {
                storageServer.close();
                trackerServer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
