package studentmanager;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 检查日期格式是否为：yyyy-mm-dd:如2012-02-28
 * 2004-02-30：无效
 * 2014-02-29：有效
 * 2001-02-29：无效
 * 2012-01-32：无效
 * @param strDate 接收日期字符串变量
 * @return 返回值
 **/
public class CheckDateFormat{
	public boolean checkDateFormat(String strDate){
		//如果输入的字符串等于10位，如："yyyy-MM-dd"，则继续下去，否则直接返回错误提示。
		if((strDate.length())!=10) 
			return false;	
		/**
		 * SimpleDateFormat 是一个以与语言环境有关的方式来格式化和解析日期的具体类。
		 * 它是DateFormat的子类
		 * 它允许进行格式化（日期 -> 文本）、解析（文本 -> 日期）和规范化。
		 * SimpleDateFormat 使得可以选择任何用户定义的日期-时间格式的模式。
		 * 但是，仍然建议通过 DateFormat 中的 getTimeInstance、getDateInstance 或 getDateTimeInstance 来创建日期-时间格式器。
		 * 每一个这样的类方法都能够返回一个以默认格式模式初始化的日期/时间格式器。
		 * 可以根据需要使用 applyPattern 方法来修改格式模式。有关使用这些方法的更多信息，请参阅 DateFormat。 
		 * */
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		try{
			//类 Date 表示特定的瞬间，精确到毫秒。 
			/**
			 * java.text.DateFormat
			 * DateFormat.parse(String s)
			 * 尝试把字符串 s 解释为日期和时间的表示形式。
			 * 如果尝试成功，则返回指示的时间，用该时间与历元（1970 年 1 月 1 日，00:00:00 GMT）的时间差来表示（以毫秒为单位）。
			 * 如果尝试失败，则抛出 IllegalArgumentException。 
			 */
			Date temDate=sdf.parse(strDate);
			String str=sdf.format(temDate);
			//出生日期合法，返回true
			if(str.equals(strDate))
				return true;
			 //出生日期不合法，返回false
			else
				return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}

