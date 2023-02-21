package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    ArrayList<Mail> inbox;
    ArrayList<Mail> trash;
    public Gmail(String emailId, int inboxCapacity) {
           super(emailId);
           inbox = new ArrayList<>();
           trash = new ArrayList<>();
           this.inboxCapacity = inboxCapacity;
    }

    public void receiveMail(Date date, String sender, String message){

        if(inbox.size() == inboxCapacity){
            trash.add(inbox.remove(0));
        }
        inbox.add(new Mail(date,sender,message));
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message){
        int index = -1;
        for(int i=0;i<inbox.size();i++){
            if(message.equals(inbox.get(i).getMessage())){
                index = i;
                break;

            }
        }

        if(index != -1){
            trash.add(inbox.get(index));
            inbox.remove(index);
        }

        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

    }

    public String findLatestMessage(){
            if(inbox.size() == 0){
                return null;
            }
            return inbox.get(inbox.size()-1).getMessage();
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox

    }

    public String findOldestMessage(){
        if(inbox.size() == 0){
            return null;
        }
        return inbox.get(0).getMessage();
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox

    }

    public int findMailsBetweenDates(Date start, Date end){
            int cnt = 0;
        for(Mail mail:inbox){
            if(!start.after(mail.getDate()) && !end.before(mail.getDate())) {
                /* historyDate <= todayDate <= futureDate */
                cnt++;
            }
        }
        return cnt;
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date

    }

    public int getInboxSize(){
        return inbox.size();
        // Return number of mails in inbox

    }

    public int getTrashSize(){
        return trash.size();
        // Return number of mails in Trash

    }

    public void emptyTrash(){
        trash.clear();
        // clear all mails in the trash

    }

    public int getInboxCapacity() {
        return inboxCapacity;
        // Return the maximum number of mails that can be stored in the inbox
    }
}
