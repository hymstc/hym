package hym.book.Tool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//���ڹ�����
public class DateUtil {

	//��ȡ���ڲ���date����һ��
	public static Date getNextDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		return c.getTime();
	}
	
	//������ת����yyyy-MM-dd�ĸ�ʽ
	public static String getDateString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
}
