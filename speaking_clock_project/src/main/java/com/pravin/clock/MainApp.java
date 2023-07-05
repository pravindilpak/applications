package com.pravin.clock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {
	
	public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter time [hh:min format]: ");
        String hour = reader.readLine();

        Clock speakingClock = new Clock(hour);
        speakingClock.displayTime();
    }

}
