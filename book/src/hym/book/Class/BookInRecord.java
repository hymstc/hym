package hym.book.Class;

//����¼���еľ�������¼
public class BookInRecord extends ValueObject {
	//��Ӧ������, �����ݿ�����ʱ��ֵ
	private String BOOK_ID_FK;
	//��Ӧ���ۼ�¼���
	private String T_IN_RECORD_ID_FK;
	//�������
	private String IN_SUM;
	//�������
	private String RECOR_DATE;
	
	//�ü�¼����Ӧ����, �����ݿ�����ʱΪnull
	private Book book;
	
	//�ü�¼����Ӧ�ĺͿ��¼, �����ݿ�����ʱΪnull
	private InRecord inRecord;

	
	public String getRECOR_DATE() {
		return RECOR_DATE;
	}

	public void setRECOR_DATE(String rECOR_DATE) {
		RECOR_DATE = rECOR_DATE;
	}

	public String getBOOK_ID_FK() {
		return BOOK_ID_FK;
	}

	public void setBOOK_ID_FK(String book_id_fk) {
		BOOK_ID_FK = book_id_fk;
	}

	public String getT_IN_RECORD_ID_FK() {
		return T_IN_RECORD_ID_FK;
	}

	public void setT_IN_RECORD_ID_FK(String t_in_record_id_fk) {
		T_IN_RECORD_ID_FK = t_in_record_id_fk;
	}

	public String getIN_SUM() {
		return IN_SUM;
	}

	public void setIN_SUM(String in_sum) {
		IN_SUM = in_sum;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public InRecord getInRecord() {
		return inRecord;
	}

	public void setInRecord(InRecord inRecord) {
		this.inRecord = inRecord;
	}
	
}
