package marc.dev.emailapp.utils;

public class EmailUtils {

    public static String getEmailMessage(String name, String host, String token){
        return "Hello " + name + ",\n\nYour new account has been created. please click to verify the link below to verify  \n\n" +
                getVerificationUrl(host, token) + "\n\nThe Support  Team";

    }

    public static String getVerificationUrl(String host, String token) {
        return  host +"/api/v1/user?token=" + token;
    }

}
