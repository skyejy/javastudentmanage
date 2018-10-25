package studentmanager;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
//������ѧ�Ų�ѯѧ���������
public class InquireOnStuID extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	//�����������ݿ����
	Connection conn;
	//����SQL������
	Statement st;
	//����������󣺱�ǩ���ı��С���ѡ
	JLabel jLabel1=new JLabel("���������ѯ��ѧ����ѧ�ţ�");
	JTextField xueHAO=new JTextField();
	JLabel xueHAO2=new JLabel("ѧ����10λ����2016030607");
	JButton jButton1=new JButton("��ѯ");
	JScrollPane jScrollPane1=new JScrollPane();
	JTextArea jTextArea1=new JTextArea();
	//���췽��
	public InquireOnStuID()
	{
		try{
			//���ó�ʼ������
			jbInit();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}
	//����ʼ������
	private void jbInit() throws Exception
	{
		//�������ݿ�
		conn=DBConnect.getConn();
		st=conn.createStatement();
		//��ܵĲ���
		this.setLayout(null);
		//���ø�����Ĵ�С
		jLabel1.setFont(new java.awt.Font("����",Font.BOLD,16));
		jLabel1.setBounds(new Rectangle(46,4,222,32));
		xueHAO.setBounds(new Rectangle(47,37,100,31));
		xueHAO2.setBounds(new Rectangle(160,37,180,30));
		jButton1.setBounds(new Rectangle(47,86,247,30));
		jScrollPane1.setBounds(new Rectangle(24,130,305,109));
		//��Ӱ�ť�����¼�
		jButton1.addActionListener(this);
		//�����������
		this.add(jScrollPane1);
		jScrollPane1.getViewport().add(jTextArea1);
		this.add(jLabel1);
		this.add(xueHAO);
		this.add(xueHAO2);
		this.add(jButton1);
	}
	//�����ť�¼�
	public void actionPerformed(ActionEvent e)
	{
		//��ȡ�û������ѧ��
		String xuehao=xueHAO.getText();
		//����ı���ԭ�е�����
		jTextArea1.setText("");
		try{
			//����st����ִ��SQL��䣬���ؽ��������
			ResultSet rs=st.executeQuery("select * from studentsinfo where xuehao='"+xuehao+"'");
			//��������:������ʾ������еļ�¼
			//�˴�û��ʹ��while����Ϊѧ����Ψһ��
			if(rs.next()){
				jTextArea1.append("ѧ��:"+rs.getString("xuehao")+"\n����:"+rs.getString("xingming")+"\n�Ա�:"+rs.getString("xingbie")+"\n��������:"
						+rs.getDate("dateString")+"\n����:"+rs.getString("jiguan")+"\n�༶��:"+rs.getString("ClassId"));
				//����ı��е�����
				xueHAO.setText("");
			}
			else
				JOptionPane.showMessageDialog(this,"û�����ѧ��!");
			}
		catch(Exception ex){
			//������Ϣ�Ի�����ʾ��ѯʧ��
			JOptionPane.showMessageDialog(this,"��ѯʧ��!");
			}
	}
}

