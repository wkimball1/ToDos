package ToDo;

import javax.persistence.*;

@Entity
@Table(name="todoitems")
public class ToDoItem {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="ToDo")
	private String item = null;
	
	
	
	public ToDoItem () {
		
		super();
		
	}
	
	public ToDoItem (String item) {
		
		this.setItem(item);
		
	}
	
	public ToDoItem (String item, int id) {
		
		this.setItem(item);
		this.setId(id);
		
	}
	
	public int getId() {
		return this.id;
		
	}
	
	public String getItem () {
		return this.item;
	}
	
	public void setId(int i) {
		this.id = i;
	}
	
	public void setItem (String i) {
		this.item = i;
	}
}
