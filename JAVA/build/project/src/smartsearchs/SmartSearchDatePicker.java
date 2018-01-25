package smartsearchs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import objects.MyTable;

public class SmartSearchDatePicker extends SmartSearch {
	
	public SmartSearchDatePicker(MyTable<?> table) {
		super(new DatePicker(LocalDate.now()), table);
		
		((DatePicker) search).setShowWeekNumbers(false);
		((DatePicker) search).setEditable(false);
		((DatePicker) search).addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
		    public void handle(ActionEvent t) {
				table.refresh(getText());
		    }
		});
	}
	
	public String getText() {
		return ((DatePicker) search).getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	@Override
	public void setText(String text) {
		((DatePicker) search).setValue(LocalDate.parse(text));
	}	

}