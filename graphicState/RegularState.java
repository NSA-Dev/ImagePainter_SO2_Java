package graphicState;

import drawingTool.Scene;

public class RegularState extends State {
	private static RegularState instance;
	private RegularState(Scene context) {
			this.context = context;
			regular = this;
	}
	
	public static RegularState getInstance(Scene scene) {
		if(instance == null) {
			instance = new RegularState(scene);
		}
		return instance; 
	}

	@Override
	public void toggleState() {
		this.context.drawScene();
		this.context.addHatsRegular();
	}

	@Override
	public State getStateRegular() {
		return this; 
	}

	@Override
	public State getStateBaseball() {
		return BaseballState.getInstance(context); 
	}

	@Override
	public State getStateMix() {
		return MixState.getInstance(context);
	}
	
	@Override
	public State getStateHatless() {
		return HatlessState.getInstance(context);
	}

	

}
