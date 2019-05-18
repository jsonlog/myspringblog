//package json.log.myspringblog.util;
//
//import org.apache.ibatis.io.Resources;
////import org.apache.ibatis.session.SqlSession;
////import org.apache.ibatis.session.SqlSessionFactory;
////import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.Reader;
//import java.math.BigInteger;
//import java.security.MessageDigest;
//import java.util.Base64;
//import java.util.Properties;
///**
// * @author jsonlog
// * @date 2019-05-17
// */
//public class DBUtils {
////    private static SqlSessionFactory sqlSessionFactory = null;
////    private static final Class CLASS_LOCK = DBUtils.class;
////
////    public static SqlSession openSqlSession() {
////        if (sqlSessionFactory == null)
////            initSqlSessionFactory();
////        return sqlSessionFactory.openSession();
////    }
//
//    public static void SpringDatasourcePassword(String pwd) {
//        InputStream proStream = null;
//        Reader proReader = null;
//        Properties properties = null;
//        try {
//            proStream = Resources.getResourceAsStream("application.properties");
//            proReader = new InputStreamReader(proStream);
//            properties = new Properties();
//            properties.load(proReader);
//            //获取密文用户名和密码
////            String username = properties.getProperty("spring.datasource.username");
////            String password = properties.getProperty("spring.datasource.password");
////            System.out.println("username"+username);
////            System.out.println("password"+password);
////            System.out.println(encrypt_Base64(password));
//            System.out.println(decrypt_Base64(pwd));
//            //解密
//            properties.setProperty("spring.datasource.password", decrypt_Base64(pwd));
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e){
//
//        }
//    }
//    /***
//     * MD5加密
//     * @param str 需要加密的参数
//     * @return
//     * @throws Exception
//     */
//    public static String encrypt_MD5(String str) throws Exception {
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        md.update(str.getBytes());
//        return new BigInteger(1,md.digest()).toString(16);
//    }
//
//    /***
//     * Base64加密
//     * @param str 需要加密的参数
//     * @return
//     * @throws Exception
//     */
//    public static String encrypt_Base64(String str) throws Exception {
//        String result = Base64.getEncoder().encodeToString(str.getBytes("UTF-8"));
//        return result;
//    }
//
//    /***
//     * Base64解密
//     * @param str 需要解密的参数
//     * @return
//     * @throws Exception
//     */
//    public static String decrypt_Base64(String str) throws Exception {
//        byte[] asBytes = Base64.getDecoder().decode(str);
//        String result = new String(asBytes,"UTF-8");
//        return result;
//    }
////    public static SqlSessionFactory initSqlSessionFactory() {
////        InputStream cfgStream = null;
////        Reader cfgReader = null;
////        InputStream proStream = null;
////        Reader proReader = null;
////        Properties properties = null;
////        try {
////            cfgStream = Resources.getResourceAsStream("mybatis-conf.xml");
////            cfgReader = new InputStreamReader(cfgStream);
////            proStream = Resources.getResourceAsStream("db.properties");
////            proReader = new InputStreamReader(proStream);
////            properties = new Properties();
////            properties.load(proReader);
////            //获取密文用户名和密码
////            String username = properties.getProperty("username");
////            String password = properties.getProperty("password");//SpringDatasourcePassword
////            //解密
////            properties.setProperty("username", ((String) username).substring(0, username.indexOf("-")));
////            properties.setProperty("password", ((String) password).substring(0, password.indexOf("-")));
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        synchronized (CLASS_LOCK) {
////            if (sqlSessionFactory == null) {
////                sqlSessionFactory = new SqlSessionFactoryBuilder().build(cfgReader,properties);
////            }
////        }
////        return sqlSessionFactory;
////    }
////
////    public static SqlSessionFactory initSqlSessionFactory2() {
////        InputStream is = null;
////        try {
////            is = Resources.getResourceAsStream("mybatis-conf.xml");
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        synchronized (CLASS_LOCK) {
////            if (sqlSessionFactory == null) {
////                sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
////            }
////        }
////        return sqlSessionFactory;
////    }
//}