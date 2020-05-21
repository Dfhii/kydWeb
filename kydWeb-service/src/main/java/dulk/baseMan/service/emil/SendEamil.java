//package dulk.baseMan.service.emil;
//
//import com.sun.mail.util.MailSSLSocketFactory;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.security.GeneralSecurityException;
//import java.util.Date;
//import java.util.Properties;
//import java.util.regex.Pattern;
//
//
//public class SendEamil {
////    public static void main(String[] args) throws MessagingException, GeneralSecurityException {
////        //创建一个配置文件并保存
////        Properties properties = new Properties();
////
////        properties.setProperty("mail.host","smtp.qq.com");
////
////        properties.setProperty("mail.transport.protocol","smtp");
////
////        properties.setProperty("mail.smtp.auth","true");
////
////
////        //QQ存在一个特性设置SSL加密
////        MailSSLSocketFactory sf = new MailSSLSocketFactory();
////        sf.setTrustAllHosts(true);
////        properties.put("mail.smtp.ssl.enable", "true");
////        properties.put("mail.smtp.ssl.socketFactory", sf);
////
////        //创建一个session对象
////        Session session = Session.getDefaultInstance(properties, new Authenticator() {
////            @Override
////            protected PasswordAuthentication getPasswordAuthentication() {
////                return new PasswordAuthentication("619046217@qq.com","16位授权码");
////            }
////        });
////
////        //开启debug模式
////        session.setDebug(true);
////
////        //获取连接对象
////        Transport transport = session.getTransport();
////
////        //连接服务器
////        transport.connect("smtp.qq.com","619046217@qq.com","16位授权码");
////
////        //创建邮件对象
////        MimeMessage mimeMessage = new MimeMessage(session);
////
////        //邮件发送人
////        mimeMessage.setFrom(new InternetAddress("619046217@qq.com"));
////
////        //邮件接收人
////        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("875203654@qq.com"));
////
////        //邮件标题
////        mimeMessage.setSubject("Hello Mail");
////
////        //邮件内容
////        mimeMessage.setContent("我的想法是把代码放进一个循环里","text/html;charset=UTF-8");
////
////        //发送邮件
////        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
////
////        //关闭连接
////        transport.close();
////    }
//private static String emailRegular = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
//
//    public static boolean validEmail(String emailAddress) {
//        return Pattern.matches(emailRegular, emailAddress);
//    }
//
//    private static String fromMailAddress = "sales@hwapu22.com";
//    private static String fromMailPwd = "kyd2020";
//    private static String fromMailSMTPHost = "smtp.exmail.qq.com";
//    private static String smtpPort = "465";
//
//    private static Properties setProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("mail.transport.protocol", "smtp");
//        properties.setProperty("mail.smtp.host", fromMailSMTPHost);
//        properties.setProperty("mail.smtp.auth", "true");
//        properties.setProperty("mail.smtp.port", smtpPort);
//        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
//        properties.setProperty("mail.smtp.socketFactory.port", smtpPort);
//        properties.setProperty("mail.smtp.ssl.enable", "true");
//        properties.setProperty("mail.debug", "true");
//        return properties;
//    }
//
//    private static Message setMail(Session session, String toEmailAdress, String emailTitle, String emailContent) throws Exception {
//        MimeMessage message = new MimeMessage(session);
//        message.setFrom(new InternetAddress(fromMailAddress, fromMailAddress, "UTF-8"));
//        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmailAdress, toEmailAdress, "UTF-8"));
//        message.setSubject(emailTitle);
//        message.setContent(emailContent, "text/html;charset=utf-8");
//        message.setSentDate(new Date());
//        message.saveChanges();
//        return message;
//    }
//
//    private static Session setSession() {
//        Properties properties = setProperties();
//        Session session = Session.getInstance(properties);
//        session.setDebug(true);
//        return session;
//    }
//
//
//    public static boolean sendEmail(String toEmailAdress, String emailContent, String emailTitle) {
//        Session session = setSession();
//        try {
//            Message message = setMail(session, toEmailAdress, emailTitle, emailContent);
//            Transport transport = session.getTransport();
//            transport.connect(fromMailAddress, fromMailPwd);
//            transport.sendMessage(message, message.getAllRecipients());
//            transport.close();
//        } catch (Exception e) {
//            System.out.println("toEmailAdress = " + toEmailAdress + ", emailContent = " + emailContent + ", emailTitle = " + emailTitle + ", error = " + e.getMessage());
//            return false;
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        SendEamil.sendEmail("miaoying.new@qq.com", "testContent", "testTitle");
//    }
//
//
//
//
//
//}
