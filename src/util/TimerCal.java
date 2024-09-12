package util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;

import model.PositionData;


public class TimerCal implements Runnable{
	
	
	String now_time="";
	String now_time_hour;
	String now_time_minutes;
	String now_time_second;
	
	public static void main (String[] args) {
		
		//System.out.println(new TimerCal().timeCalTest());
		
		TimerCal time=new TimerCal();
		
		Thread t1=new Thread(time);
		t1.start();
		
		/*
		TimerCal time1=new TimerCal();
		Thread t2=new Thread(time.now_time);
		System.out.println(time.now_time);
		t2.start();
		*/
	}
	
	public LocalDateTime timeCalTest() {
		
		for(int i=1;i<2;i++) {
			i--;
			try {
				Thread.sleep(1000);
				LocalDateTime ldt=LocalDateTime.now();
				String DateTime_login=ldt.
						format(DateTimeFormatter.ofPattern("YYY/MM/dd-HH:mm:ss"))
						.toString();
				/*
				Thread.sleep(1000);
				LocalTime l1=LocalTime.now();
				LocalTime l2=LocalTime.of(15, 40, 30);
				*/
				/*
				System.out.println(l1);
				System.out.println(l2);
				
				System.out.println("時:"+l1.getHour());
				System.out.println("分:"+l1.getMinute());
				System.out.println("秒:"+l1.getSecond());
				*/
				//String now_time="時:"+l1.getHour()+"分:"+l1.getMinute()+"秒:"+l1.getSecond();
				
				return ldt;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public void run() {
		
		for(int i=1;i<2;i++) {
			i--;
			try {
				Thread.sleep(1000);
				LocalTime l1=LocalTime.now();
				LocalTime l2=LocalTime.of(15, 40, 30);
				
				System.out.println(l1);
				System.out.println(l2);
				
				
				System.out.println("時:"+l1.getHour());
				System.out.println("分:"+l1.getMinute());
				System.out.println("秒:"+l1.getSecond());
				
				
				this.now_time="時:"+l1.getHour()+"分:"+l1.getMinute()+"秒:"+l1.getSecond();
				this.now_time_hour="時:"+l1.getHour();
				this.now_time_minutes="分:"+l1.getMinute();
				this.now_time_second="秒:"+l1.getSecond();
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
    
}
