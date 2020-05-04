
package projet_info;

import java.util.ArrayList;
import java.util.List;

public class Case  {
	List<Unite> unites;
	

	Case() {
		this.unites = new ArrayList<Unite>();
    }
	
	void ajouterUnite(Unite unite) {
		this.unites.add(unite);
	}
	
}

