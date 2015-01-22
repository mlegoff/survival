package gameframework.base;

import gameframework.motion.GameMovableDriverDefaultImpl;
import gameframework.motion.MoveStrategy;
import gameframework.motion.blocking.MoveBlockerChecker;

public class ObservableMovableDriver extends GameMovableDriverDefaultImpl {
	
	public ObservableMovableDriver(MoveStrategy m, MoveBlockerChecker blocker) {
		super();
		this.setmoveBlockerChecker(blocker);
		this.moveStrategy = m;
	}
}
