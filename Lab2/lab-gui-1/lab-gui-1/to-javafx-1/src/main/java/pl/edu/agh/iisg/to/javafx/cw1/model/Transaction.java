package pl.edu.agh.iisg.to.javafx.cw1.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.math.BigInteger;
import java.time.LocalDate;

public class Transaction {
	
	private static final String EMPTY = "";
		
	private ObjectProperty<LocalDate> date;
	private StringProperty payee;
	private ObjectProperty<Category> category;
	private ObjectProperty<BigInteger> inflow;

	
	private Transaction() {
		this(LocalDate.now(), EMPTY, new Category(EMPTY), BigInteger.ZERO);
	}
	
	public Transaction(LocalDate date, String payee, Category category, BigInteger inflow) {
		this.date = new SimpleObjectProperty<>(date);
		this.payee = new SimpleStringProperty(payee);
		this.category = new SimpleObjectProperty<>(category);
		this.inflow = new SimpleObjectProperty<>(inflow);
	}

	public final ObjectProperty<LocalDate> getDateProperty() {
		return date;
	}

	public final void setDate(ObjectProperty<LocalDate> date) {
		this.date = date;
	}
	

	public final StringProperty getPayeeProperty() {
		return payee;
	}
	
	public final void setPayee(StringProperty payee) {
		this.payee = payee;
	}

	
	public final ObjectProperty<Category> getCategoryProperty() {
		return category;
	}
	
	
	public final void setCategory(ObjectProperty<Category> category) {
		this.category = category;
	}


	public final ObjectProperty<BigInteger> getInflowProperty() {
		return inflow;
	}

	public final void setInflow(ObjectProperty<BigInteger> inflow) {
		this.inflow = inflow;
	}
	
	public static final Transaction newTransaction() {
		return new Transaction();
	}
}
