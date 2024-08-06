package graphicState;

import drawingTool.Scene;

public class MixState extends State{

	private static MixState instance;
	private MixState(Scene context) {
			this.context = context;
			mix = this;
	}
	
	public static MixState getInstance(Scene scene) {
		if(instance == null) {
			instance = new MixState(scene);
		}
		return instance; 
	}
	@Override
	public void toggleState() {
		this.context.drawScene();
		this.context.addHatsMix();
		
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

		return this;
	}
	
	@Override
	public State getStateHatless() {
		return HatlessState.getInstance(context);
	}



}
