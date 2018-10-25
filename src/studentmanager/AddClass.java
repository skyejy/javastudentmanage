package studentmanager;

//��Ӱ༶�����
//����ϵͳ�����
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
//��������Ӱ༶��塱�࣬���̳�Jpanel�࣬�Ͷ������������
public class AddClass extends JPanel implements ActionListener 
{
	//����һ����̬���������͵ı���serialVersionUID���˴���֪ʲô�ã�����û�����,������о��档��д�������У�Ҳ��Ӱ��������С�
	private static final long serialVersionUID = 1L;
	//����һ���������ݿ�Ķ���
	Connection conn;
	//����һ������������ִ��SQL���
	Statement statement;
	/*
	 * �����Ǵ���������󣺱�ǩ���ı��С���ѡ����ť��ϸ��
	 */
	//����һ����ǩ����ClassID������ʾѧ��
	JLabel ClassID=new JLabel("�༶�ţ�");
	//����һ���ı���������ClassID2��������ѧ���ַ���
	JTextField ClassID2=new JTextField();
	//����һ����ǩ����ClassID3������ʾ��ע��ѧ�ŵĸ�ʽ
	JLabel ClassID3=new JLabel("�༶����6λ������:201601");
	//����һ����ǩ����XiID������ʾ��������ϵ��
	JLabel XiID=new JLabel("����ϵ��");
	//����һ���ı���������XiID2����������������ϵ��
	JTextField XiID2=new JTextField();
	//����һ����ǩ����XiID3������ʾ��ע��ѧ�ŵĸ�ʽ
	JLabel XiID3=new JLabel("����ϵ����2λ������:01");
	//����һ����ǩ����ClassTeacher������ʾ������
	JLabel ClassTeacher=new JLabel("�����Σ�");
	//����һ���ı���������ClassTeacher2�������������
	JTextField ClassTeacher2=new JTextField();
	//����һ����ǩ����ClassNum������ʾ�༶����
	JLabel ClassNum=new JLabel("�༶������");
	//����һ���ı���������ClassNum2��������༶����
	JTextField ClassNum2=new JTextField();
		
	//����һ����ť����addClass������Ӱ༶��Ϣ�����ݿ�
	JButton addClass=new JButton("��Ӱ༶");
	//���ѧ�������Ĺ��췽��
	public AddClass()
	{
		try{
			//�������ѧ���ĳ�ʼ������
			jbInit();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	//��Ӱ༶ͼ�ν���ĳ�ʼ����������ʼ���������������
	private void jbInit() throws Exception
	{
		//����DBConnect.java�ڵ�getConn����,��ʼ��conn�������������ݿ�
		conn=DBConnect.getConn();
		//�������ݿ�󣬳�ʼ��statement�������� SQL��䷢�͵����ݿ⡣
		statement=conn.createStatement();
		/*
		 * �Ȱѵ�ǰ��������this���Ĳ��ֹ������ÿգ�������µ��������ǰ���������С�
		 * setLayout,����java.awt.*�еĽӿڣ������JAVA_API_1.6.CHM�ļ���
		 */
		this.setLayout(null);
		/*
		 * ���ø�����Ĵ�С���ڵ�ǰ�����е�λ��
		 */
		//setBounds(new Rectangle(x,y,w,h)),�ƶ�������������С���� x �� y ָ�����Ͻǵ���λ�ã��� w�� hָ���µĴ�С,ʹ������µ��н���� ��
		//��ǩ���༶�ŵĴ�С��λ�á�
		ClassID.setBounds(new Rectangle(21,20,60,25));
		//�ı�����򣺰༶�ţ��Ĵ�С��λ��
		ClassID2.setBounds(new Rectangle(80,20,100,25));
		//��ǩ���༶�Ÿ�ʽ���Ĵ�С��λ��
		ClassID3.setBounds(new Rectangle(190,20,170,25));
		//��ǩ��ϵ�ţ��Ĵ�С��λ��
		XiID.setBounds(new Rectangle(18,55,65,25));
		//�ı������ϵ�ţ��Ĵ�С��λ��
		XiID2.setBounds(new Rectangle(80,55,100,25));
		//��ǩ��ϵ�Ÿ�ʽ���Ĵ�С��λ��
		XiID3.setBounds(new Rectangle(190,55,170,25));
		//��ǩ�������Σ��Ĵ�С��λ��
		ClassTeacher.setBounds(new Rectangle(21,92,60,25));
		//�ı�����򣺰����Σ��Ĵ�С��λ��
		ClassTeacher2.setBounds(new Rectangle(80,92,100,25));
		//��ǩ���༶�������Ĵ�С��λ��
		ClassNum.setBounds(new Rectangle(12,130,65,25));
		//�ı�����򣺰༶�������Ĵ�С��λ��
		ClassNum2.setBounds(new Rectangle(80,130,100,25));
		
		
		addClass.setBounds(new Rectangle(110,180,180,30));
		/** 
		 * �ԡ����ѧ������ť����Ӷ����¼���������������ǰ���塣
		 * �����¡����ѧ������ť�����Զ�����actionPerformed(ActionEvent e)����
		 * */
		addClass.addActionListener(this);
		/*
		 * �������ʼ����ɵĸ����������ӵ���ǰ���������ڡ�
		 */
		//��ӱ�ǩ���༶��
		this.add(ClassID);
		//����ı�����򣬰༶��
		this.add(ClassID2);
		//��ӱ�ǩ���༶�Ÿ�ʽ
		this.add(ClassID3);
		//��ӱ�ǩ��ϵ��
		this.add(XiID);
		//����ı������ϵ��
		this.add(XiID2);
		//��ӱ�ǩ��ϵ�Ÿ�ʽ
		this.add(XiID3);
		//��ӱ�ǩ��������
		this.add(ClassTeacher);
		//����ı�����򣬰�����
		this.add(ClassTeacher2);
		//��ӱ�ǩ���༶����
		this.add(ClassNum);
		//����ı�����򣬰༶����
		this.add(ClassNum2);
		//��Ӱ�ť����Ӱ༶
		this.add(addClass);
	}
	
	
	//�����ť���ѧ�����и��������¼������ö���
	public void actionPerformed(ActionEvent e)
	{
		//����banjihao�����Ѽ��༶����Ϣ
		String banjihao=ClassID2.getText();
		//����xihao�����Ѽ�ϵ��
		String xihao=XiID2.getText();
		//����bzr�����Ѽ�������
		String bzr=ClassTeacher2.getText();
		//����renshu�����Ѽ���������Ϣ
		String renshu=ClassNum2.getText();
		//�༶���Ѿ����ڵĲ�������룡���ز����Ѵ��󣺸�ѧ���Ѿ����ڡ�
		try{
			ResultSet rs=statement.executeQuery("select * from classinfo where ClassId='"+banjihao+"'");
			if(rs.next()){
				JOptionPane.showMessageDialog(this,"�ð༶���Ѿ����ڣ�����������룡");
				return;
				}
			}catch(Exception ex){
					//��������쳣��������Ϣ�Ի�����ʾ���ܲ��룬����ʾ�쳣����Ϣ
				ex.printStackTrace();
			}
		
		//��һ�������飬�༶��Ϊ�ǿ�����6λ����ϵ�ŷǿ�����2λ����������������
		if(!((banjihao.length())==6 && (xihao.length())==2)){
			JOptionPane.showMessageDialog(this,"�������ݸ�ʽ��������������룡");
			return;
		}
		
		//�쳣����
		try{
			//����statement����ִ��SQL��䣬���в������
			statement.executeUpdate("insert into classinfo values('"+banjihao
					+"','"+bzr+"','"+renshu+"','"+xihao+"')");
			//������Ϣ�Ի�����ʾ��������ɹ�
			//JOptionPane �����ڷ���ص���Ҫ���û��ṩֵ�����䷢��֪ͨ�ı�׼�Ի���
			JOptionPane.showMessageDialog(this,"����༶��Ϣ�ɹ���");
			//����ı������ѧ�š��������������ڡ����������
			ClassID2.setText("");
			XiID2.setText("");
			ClassTeacher2.setText("");
			ClassNum2.setText("");
		}catch(Exception ex){
			//��������쳣��������Ϣ�Ի�����ʾ���ܲ��룬����ʾ�쳣����Ϣ
			JOptionPane.showMessageDialog(this,"�������ݸ�ʽ������������룡");
			ex.printStackTrace();
		}
	}
}
