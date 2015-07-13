package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.*;


public class QueryAction {
	public static ActionListener getQuery1() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParameterQuery1 frame = new ParameterQuery1();
			}
		};
	}
	
	public static ActionListener getQuery2() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParameterQuery2 frame = new ParameterQuery2();
			}
		};
	}
	public static ActionListener getQuery3() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParameterQuery3 frame = new ParameterQuery3();
			}
		};
	}
}