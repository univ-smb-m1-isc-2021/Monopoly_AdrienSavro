package tp;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
	
	private List<Case> cases;
	
	public Plateau(List<Case> cases) {
		this.setCases(cases);
	}

	public List<Case> getCases() {
		return cases;
	}

	public void setCases(List<Case> cases) {
		this.cases = cases;
	}

}
