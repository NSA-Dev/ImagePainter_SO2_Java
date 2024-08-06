package graphicState;

import drawingTool.Scene;

public class HatlessState extends State {
	private static HatlessState instance;
	private HatlessState(Scene context) {
			this.context = context;
			noHat = this;
	}
	
	public static HatlessState getInstance(Scene scene) {
		if(instance == null) {
			instance = new HatlessState(scene);
		}
		return instance; 
	}

	@Override
	public void toggleState() {
		this.context.drawScene();
	}

	@Override
	public State getStateRegular() {
		return RegularState.getInstance(context); 
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
		return this;
	}



}
