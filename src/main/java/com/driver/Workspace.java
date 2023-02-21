package com.driver;

import org.apache.commons.lang3.tuple.Pair;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId, Integer.MAX_VALUE);
        this.calendar = new ArrayList<>();
        // The inboxCapacity is equal to the maximum value an integer can store.

    }

    public void addMeeting(Meeting meeting){
        calendar.add(meeting);
        //add the meeting to calendar

    }

    public int findMaxMeetings(){
        ArrayList<Pair<LocalTime,LocalTime>> currcalendar = new ArrayList<>();
        for(Meeting m :calendar){
            currcalendar.add(Pair.of(m.getStartTime(),m.getEndTime()));
        }
        Collections.sort(currcalendar);
        int cnt = 1;
        Pair<LocalTime,LocalTime> p = currcalendar.get(0);
        for(int i=1;i<currcalendar.size();i++){
            if(currcalendar.get(i).getLeft().compareTo(p.getRight()) > 0){
                cnt++;
                p = currcalendar.get(i);
            }
        }
        return cnt;
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

    }
}
