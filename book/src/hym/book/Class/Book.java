package hym.book.Class;

//�鱾��
public class Book extends ValueObject {
	//�鱾����
	private String BOOK_NAME;
	//���
	private String BOOK_INTRO;
	//��ĵ���
	private String BOOK_PRICE;
	//�������
	private String TYPE_ID_FK;
	//���������
	private String PUB_ID_FK;
	//�洢��
	private String REPERTORY_SIZE;
	//����ͼurl
	private String IMAGE_URL;
	
	//�鱾���࣬�����ݿ��ѯ������ʱ���������Ϊnull����ͨ�������TYPE_ID_FKȥ�����������
	private Type type;
	
	//���Ӧ�ĳ����磬��type��ͬ
	private Concern concern;
	
	private String AUTHOR;
	
	public Book() {
		
	}
	
	public Book(String id, String book_name, String book_intro, String book_price,
			String type_id_fk, String pub_id_fk, String repertory_size, 
			String image_url, String author) {
		setID(id);
		BOOK_NAME = book_name;
		BOOK_INTRO = book_intro;
		BOOK_PRICE = book_price;
		TYPE_ID_FK = type_id_fk;
		PUB_ID_FK = pub_id_fk;
		REPERTORY_SIZE = repertory_size;
		IMAGE_URL = image_url;
		AUTHOR = author;
	}

	public String getBOOK_NAME() {
		return BOOK_NAME;
	}

	public void setBOOK_NAME(String book_name) {
		BOOK_NAME = book_name;
	}

	public String getBOOK_INTRO() {
		return BOOK_INTRO;
	}

	public void setBOOK_INTRO(String book_intro) {
		BOOK_INTRO = book_intro;
	}

	public String getBOOK_PRICE() {
		return BOOK_PRICE;
	}

	public void setBOOK_PRICE(String book_price) {
		BOOK_PRICE = book_price;
	}

	public String getTYPE_ID_FK() {
		return TYPE_ID_FK;
	}

	public void setTYPE_ID_FK(String type_id_fk) {
		TYPE_ID_FK = type_id_fk;
	}

	public String getPUB_ID_FK() {
		return PUB_ID_FK;
	}

	public void setPUB_ID_FK(String pub_id_fk) {
		PUB_ID_FK = pub_id_fk;
	}

	public String getREPERTORY_SIZE() {
		return REPERTORY_SIZE;
	}

	public void setREPERTORY_SIZE(String repertory_size) {
		REPERTORY_SIZE = repertory_size;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Concern getConcern() {
		return concern;
	}

	public void setConcern(Concern concern) {
		this.concern = concern;
	}

	public String getIMAGE_URL() {
		return IMAGE_URL;
	}

	public void setIMAGE_URL(String image_url) {
		IMAGE_URL = image_url;
	}

	public String getAUTHOR() {
		return AUTHOR;
	}

	public void setAUTHOR(String author) {
		AUTHOR = author;
	}
	
}
