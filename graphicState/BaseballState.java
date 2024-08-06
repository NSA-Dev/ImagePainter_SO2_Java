package graphicState;

import drawingTool.Scene;

public class BaseballState extends State{
	private static BaseballState instance;
	private BaseballState(Scene context) {
			this.context = context;
			baseball = this;
	}
	
	public static BaseballState getInstance(Scene scene) {
		if(instance == null) {
			instance = new BaseballState(scene);
		}
		return instance; 
	}

	@Override
	public void toggleState() {

		this.context.drawScene();
		this.context.addHatsBaseball();
	}

	@Override
	public State getStateRegular() {
		// TODO Auto-generated method stub
		return RegularState.getInstance(context); 
	}

	@Override
	public State getStateBaseball() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public State getStateMix() {
		// TODO Auto-generated method stub
		return MixState.getInstance(context);
	}
	public State getStateHatless() {
		// TODO Auto-generated method stub
		return HatlessState.getInstance(context);
	}


}
