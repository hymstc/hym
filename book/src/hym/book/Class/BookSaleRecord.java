package hym.book.Class;


//���۱��еľ������ۼ�¼
public class BookSaleRecord extends ValueObject {

	//�ü�¼��Ӧ��������
	private String BOOK_ID_FK;
	
	//�ü�¼��Ӧ�����ۼ�¼�����
	private String T_SALE_RECORD_ID_FK;
	
	//�ü�¼����Ӧ�������������
	private String TRADE_SUM;
	
	//�ü�¼��Ӧ�������, �������ݿ���ҵ�BookSaleRecordʱ, ������Ϊnull
	private Book book;
	
	//�ü�¼��Ӧ�����ۼ�¼����, �������ݿ���ҵ�BookSaleRecordʱ, ������Ϊnull
	private SaleRecord saleRecord;

	public String getBOOK_ID_FK() {
		return BOOK_ID_FK;
	}

	public void setBOOK_ID_FK(String book_id_fk) {
		BOOK_ID_FK = book_id_fk;
	}

	public String getT_SALE_RECORD_ID_FK() {
		return T_SALE_RECORD_ID_FK;
	}

	public void setT_SALE_RECORD_ID_FK(String t_sale_record_id_fk) {
		T_SALE_RECORD_ID_FK = t_sale_record_id_fk;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public SaleRecord getSaleRecord() {
		return saleRecord;
	}

	public void setSaleRecord(SaleRecord saleRecord) {
		this.saleRecord = saleRecord;
	}

	public String getTRADE_SUM() {
		return TRADE_SUM;
	}

	public void setTRADE_SUM(String trade_sum) {
		TRADE_SUM = trade_sum;
	}
	
	
}
