import java.util.Random;
 
 
public class oddEvenGame {
	public int Number = 0;
	public int Number2 = 0;
	public Boolean Even;
	public String color;
	public String message;
	

	
	public boolean getEven(){
		Random r = new Random();
        Number += r.nextInt(100);
        Number2 = Number;
        
        if((Number%2)==0){
                   Even = true;// even
        return true;}
                else {
                        Even = false;//odd
                return false;}
	}   
                }