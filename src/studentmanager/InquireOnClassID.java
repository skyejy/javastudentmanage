package studentmanager;

//����ϵͳ�����
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
//����������Ų�ѯ�༶��塱��
public class InquireOnClassID extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	//�����������ݿ����
	Connection conn;
	//����SQL������
	Statement st;
	//����������󣺱�ǩ���ı��С���ѡ
	JLabel bjID=new JLabel("���������ѯ�İ༶�ţ�");
	JTextField jTextField1=new JTextField();
	JLabel bjID2=new JLabel("�༶����6λ����201603");
	JButton jButton1=new JButton("��ѯ");
	JScrollPane jScrollPane1=new JScrollPane();
	JTextArea jTextArea1=new JTextArea();
	//���췽��
	public InquireOnClassID()
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
		bjID.setFont(new java.awt.Font("����",Font.BOLD,16));
		bjID.setBounds(new Rectangle(46,4,222,32));
		
		jTextField1.setBounds(new Rectangle(47,37,100,31));
		bjID2.setBounds(new Rectangle(160,37,180,30));
		
		jButton1.setBounds(new Rectangle(47,86,130,30));
		jScrollPane1.setBounds(new Rectangle(47,130,250,109));
		//��Ӱ�ť�����¼�
		jButton1.addActionListener(this);
		//�����������
		this.add(jScrollPane1);
		jScrollPane1.getViewport().add(jTextArea1);
		this.add(bjID);
		this.add(jTextField1);
		this.add(bjID2);
		this.add(jButton1);
		jScrollPane1.setVisible(false);
	}
	//�����ť�¼�
	public void actionPerformed(ActionEvent e)
	{
		//��ȡ�û�����İ༶��
		String banji=jTextField1.getText();
		//����ı���ԭ�е�����
		jTextArea1.setText("");
		jScrollPane1.setVisible(true);
		try{
			//����st����ִ��SQL��䣬���ؽ��������
			ResultSet rs=st.executeQuery("select * from classinfo where ClassId='"+banji+"'");
			//��������:������ʾ������еļ�¼
			//�˴�û��ʹ��while����Ϊѧ����Ψһ��
			if(rs.next()){
				jTextArea1.append("�༶��:"+rs.getString("ClassId")+"\n������:"+rs.getString("ClassTeacher")+"\n�༶����:"+rs.getString("StuNum")+"\nϵ��:"+rs.getString("XiId"));
				//����ı��е�����
				jTextField1.setText("");
			}
			else
				JOptionPane.showMessageDialog(this,"û��������!");
		}
		catch(Exception ex){
			//������Ϣ�Ի�����ʾ��ѯʧ��
			JOptionPane.showMessageDialog(this,"��ѯʧ��!");
		}
	}
}

