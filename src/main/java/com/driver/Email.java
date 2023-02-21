package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public boolean isValid(String pass){
        if(pass.length() < 8) return false;
        boolean up = false;
        boolean lw = false;
        boolean d = false;
        boolean sp = false;
        for(int i=0;i< pass.length();i++){
            if(pass.charAt(i) >= 'A' && pass.charAt(i) <= 'Z'){
                up = true;
            }else if(pass.charAt(i) >= 'a' && pass.charAt(i) <= 'z'){
                lw = true;
            }else if(pass.charAt(i) >= '0' && pass.charAt(i) <= '9'){
                d = true;
            }else{
                sp = true;
            }
        }
        if(up == true && lw == true && d == true && sp == true){
            return true;
        }else{
            return false;
        }
    }
    public void changePassword(String oldPassword, String newPassword){
        if(oldPassword.equals(password)){
            if(isValid(newPassword)){
                this.password = newPassword;
            }else{
                System.out.println("The new password is not valid!");
            }
        }else{
            System.out.println("The given password does not match current password!");
        }
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
}
