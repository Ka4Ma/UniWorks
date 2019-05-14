import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Movement{
	FinchMove finchmv = new FinchMove();
	int Velo = finchmv.Velo;
	Finch finch = new Finch();
	int green = 255;
	public void MoveForward() {
		finch.setWheelVelocities(Velo, Velo, 500);
		finch.setLED(green,0,0);
		
	}
	public void MoveBackward() {
		finch.setWheelVelocities(Velo, Velo, 500);
		finch.setLED(green,0,0);
		
	}
	public void TurnLeft() {
		finch.setWheelVelocities(Velo, Velo, 500);
		finch.setLED(green,0,0);
		
	}
	public void TurnRight() {
		finch.setWheelVelocities(Velo, Velo, 500);
		finch.setLED(green,0,0);
		
	}
	public void Stop() {
		finch.setWheelVelocities(0, 0, 500);
		finch.setLED(green,0,0);
		
	}
	

}