package games.chocoboRun.util;

public class Timer {

	long start;
	long tmp;
	boolean isStop = true;
	boolean isPaused;

	public Timer(){

	}

	public void start(){
		isStop = false;
		start = System.currentTimeMillis();
	}
	public void stop(){
		isStop = true;
		isPaused = false;
	}
	public void pause(){
		if(!isStop){
		tmp = System.currentTimeMillis()-start;
		isPaused = true;
		}
	}
	public void resume(){
		start = System.currentTimeMillis()-tmp;
		isPaused = false;
	}

	public long getTime(){
		if(!isStop && !isPaused)
			return System.currentTimeMillis()-start;
		else if(isPaused)
			return tmp;
		else
			return 0;
	}

}
