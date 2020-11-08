package shy.fastdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

public class FastDFSUtil {

    public static void main(String[] args) {

        delete();
    }

    /**
     * 文件上传
     */
    public static void upload() {
//        读取配置文件
        TrackerServer ts = null;
        StorageServer ss = null;
        try {
            ClientGlobal.init("fastdfs.conf");
            TrackerClient tc = new TrackerClient();
             ts = tc.getConnection();
             ss = tc.getStoreStorage(ts);
//            定义storage的客服端对象，需要使用这个对象来完成具体的文件上传，下载和删除操作
            StorageClient sc = new StorageClient(ts,ss);
            /**
             * 文件上传
             * 参数1 文件路径的绝对路径
             * 参数2 文件的拓展名
             * 参数3 文件的属性，通常不上传
             * 返回一个string数组，这个数据对我们非常重要建议用数据库保存
             */
            String[] string = sc.upload_file("F:\\mm1 .jpg","jpg",null);

            for (String s : string){
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }finally {
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ts != null) {
                try {
                    ts.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }

//   下载文件
    public static void downlocal() {
//        读取配置文件
        TrackerServer ts = null;
        StorageServer ss = null;
        try {
            ClientGlobal.init("fastdfs.conf");
            TrackerClient tc = new TrackerClient();
             ts = tc.getConnection();
             ss = tc.getStoreStorage(ts);
//            定义storage的客服端对象，需要使用这个对象来完成具体的文件上传，下载和删除操作
            StorageClient sc = new StorageClient(ts,ss);
            /**
             * 文件下载
             * 参数1 需要下载的文件名的组名
             * 参数2 需要下载远程文件名
             * 参数3 需要保存本地文件名
             * 返回一个值int类型，返回值0 表示下载成功
             * 不是0就是错误
             */
            String gn = "group1";
            String rn = "M00/00/00/wKjtgF8VJ6GAHfX5AAC4ijm2MO4654.jpg";
            String ln = "D:/aa.jpg";
            int mus = sc.download_file(gn,rn,ln);
            System.out.println(mus);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }finally {
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ts != null) {
                try {
                    ts.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }

//    文件删除
    public static void delete() {
//        读取配置文件
        TrackerServer ts = null;
        StorageServer ss = null;
        try {
            ClientGlobal.init("fastdfs.conf");
            TrackerClient tc = new TrackerClient();
             ts = tc.getConnection();
             ss = tc.getStoreStorage(ts);
//            定义storage的客服端对象，需要使用这个对象来完成具体的文件上传，下载和删除操作
            StorageClient sc = new StorageClient(ts,ss);
            /**
             * 文件删除
             * 参数1 需要下载的文件名的组名
             * 参数2 需要下载远程文件名
             * 返回一个值int类型，返回值0 表示下载成功
             * 不是0就是错误
             */
            String gn = "group1";
            String rn = "M00/00/00/wKjtgF8VJ6GAHfX5AAC4ijm2MO4654.jpg";
            int mus = sc.delete_file(gn,rn);
            System.out.println(mus);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }finally {
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ts != null) {
                try {
                    ts.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }

}
