package hym.book.Class;

import java.util.Vector;

//��Ӧһ�����ڵ�����¼��
public class InRecord extends ValueObject {

	//�������
	private String RECORD_DATE;
	
	//����������
	private int amount;
	
	//������¼����Ӧ���������¼
	private Vector<BookInRecord> bookInRecords;
	
	//����������, �Զ��Ÿ���
	private String bookNames;

	public String getRECORD_DATE() {
		return RECORD_DATE;
	}

	public void setRECORD_DATE(String record_date) {
		RECORD_DATE = record_date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Vector<BookInRecord> getBookInRecords() {
		return bookInRecords;
	}

	public void setBookInRecords(Vector<BookInRecord> bookInRecords) {
		this.bookInRecords = bookInRecords;
	}

	public String getBookNames() {
		return bookNames;
	}

	public void setBookNames(String bookNames) {
		this.bookNames = bookNames;
	}
	
	
}
