package org.cx.game.command.check;

import java.util.ArrayList;
import java.util.List;

import org.cx.game.command.check.CheckEvent;
import org.cx.game.command.check.ICheck;
import org.cx.game.validator.exception.ValidatorException;

public class CheckHelper {
	
	private List<ICheck> checkerList = new ArrayList<ICheck>();
	
	public void setCheckerList(List<ICheck> checkerList) {
		this.checkerList = checkerList;
	}
	
	public void check(Object source, String method, Object [] arguments) throws ValidatorException {
		CheckEvent ce = new CheckEvent(source, method, arguments);
		
		for(ICheck check : this.checkerList){
			if(check.isMatch(ce)){
				check.check(ce);
			}
		} 
	}
}
