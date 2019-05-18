//package json.log.myspringblog.util;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.Properties;
//
//import org.springframework.util.DefaultPropertiesPersister;
//
///**
// * @author jsonlog
// * @date 2019-05-17
// */
//public class MyPropertiesPersist extends DefaultPropertiesPersister {
//
//    public void load(Properties props, InputStream is) throws IOException{
//
//        Properties properties = new Properties();
//        properties.load(is);
//
//        if ( (properties.get("password") != null) ){
//            /*这里通过解密算法，得到你的真实密码，然后写入到properties中*/
////        String password = getRealPassword( decrypter , properties.getProperty("password") );
////        properties.setProperty("password" , password);
//        }
//        OutputStream outputStream = null;
//        try {
//            outputStream = new ByteArrayOutputStream();
//            properties.store(outputStream, "");
//            is = outStream2InputStream(outputStream);
//            super.load(props, is);
//        }catch(IOException e) {
//            throw e;
//        }finally {
//            outputStream.close();
//        }
//    }
//
//
//    private InputStream outStream2InputStream(OutputStream out){
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        bos = (ByteArrayOutputStream) out ;
//        ByteArrayInputStream swapStream = new ByteArrayInputStream(bos.toByteArray());
//        return swapStream;
//    }
//}