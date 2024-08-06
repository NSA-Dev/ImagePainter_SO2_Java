package graphicState;

import drawingTool.Scene;

public abstract class State {
	protected  Scene context;
	
	protected static HatlessState noHat; 
	protected static RegularState regular;
	protected static BaseballState baseball;
	protected static MixState mix;
	
	public abstract void toggleState();
	public abstract State getStateHatless(); 
	public abstract State getStateRegular();
	public abstract State getStateBaseball();
	public abstract State getStateMix();
	

}
