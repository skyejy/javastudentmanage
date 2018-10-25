package studentmanager;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ������ڸ�ʽ�Ƿ�Ϊ��yyyy-mm-dd:��2012-02-28
 * 2004-02-30����Ч
 * 2014-02-29����Ч
 * 2001-02-29����Ч
 * 2012-01-32����Ч
 * @param strDate ���������ַ�������
 * @return ����ֵ
 **/
public class CheckDateFormat{
	public boolean checkDateFormat(String strDate){
		//���������ַ�������10λ���磺"yyyy-MM-dd"���������ȥ������ֱ�ӷ��ش�����ʾ��
		if((strDate.length())!=10) 
			return false;	
		/**
		 * SimpleDateFormat ��һ���������Ի����йصķ�ʽ����ʽ���ͽ������ڵľ����ࡣ
		 * ����DateFormat������
		 * ��������и�ʽ�������� -> �ı������������ı� -> ���ڣ��͹淶����
		 * SimpleDateFormat ʹ�ÿ���ѡ���κ��û����������-ʱ���ʽ��ģʽ��
		 * ���ǣ���Ȼ����ͨ�� DateFormat �е� getTimeInstance��getDateInstance �� getDateTimeInstance ����������-ʱ���ʽ����
		 * ÿһ���������෽�����ܹ�����һ����Ĭ�ϸ�ʽģʽ��ʼ��������/ʱ���ʽ����
		 * ���Ը�����Ҫʹ�� applyPattern �������޸ĸ�ʽģʽ���й�ʹ����Щ�����ĸ�����Ϣ������� DateFormat�� 
		 * */
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		try{
			//�� Date ��ʾ�ض���˲�䣬��ȷ�����롣 
			/**
			 * java.text.DateFormat
			 * DateFormat.parse(String s)
			 * ���԰��ַ��� s ����Ϊ���ں�ʱ��ı�ʾ��ʽ��
			 * ������Գɹ����򷵻�ָʾ��ʱ�䣬�ø�ʱ������Ԫ��1970 �� 1 �� 1 �գ�00:00:00 GMT����ʱ�������ʾ���Ժ���Ϊ��λ����
			 * �������ʧ�ܣ����׳� IllegalArgumentException�� 
			 */
			Date temDate=sdf.parse(strDate);
			String str=sdf.format(temDate);
			//�������ںϷ�������true
			if(str.equals(strDate))
				return true;
			 //�������ڲ��Ϸ�������false
			else
				return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}

