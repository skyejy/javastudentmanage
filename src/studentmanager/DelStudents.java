package studentmanager;

//ɾ��ѧ�������

//����ϵͳ�����
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

//������ɾ��ѧ����塱��
public class DelStudents extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	// �����������ݿ����
	Connection conn;
	// ����SQL������
	Statement st;
	// �����������
	JLabel jLabel1 = new JLabel("�������ɾ����ѧ����ѧ��:");
	JLabel jLabel2 = new JLabel("(10λ��,��:2016040506)");
	JTextField jTextField1 = new JTextField();
	JButton jButton1 = new JButton("ɾ��");
	JButton jButton2 = new JButton("ȷ��ɾ��");
	JScrollPane jScrollPane1 = new JScrollPane();
	JTextArea jTextArea1 = new JTextArea();

	// ���췽��
	public DelStudents() {
		try {
			// ���ó�ʼ������
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	// �����ʼ������
	private void jbInit() throws Exception {
		// �������ݿ�
		conn = DBConnect.getConn();
		st = conn.createStatement();
		// ��ܵĲ���
		this.setLayout(null);
		// ���ø�����Ĵ�С
		jLabel1.setFont(new java.awt.Font("����", Font.BOLD, 16));
		jLabel1.setBounds(new Rectangle(40, 10, 220, 30));
		jTextField1.setBounds(new Rectangle(260, 10, 80, 25));
		jLabel2.setBounds(new Rectangle(230, 30, 140, 30));
		jButton1.setBounds(new Rectangle(120, 60, 150, 30));
		jButton2.setBounds(new Rectangle(100, 210, 170, 30));
		jScrollPane1.setBounds(new Rectangle(80, 60, 220, 140));
		// ��Ӱ�ť�����¼�
		jButton1.addActionListener(this);
		jButton2.addActionListener(this);
		// �����������
		this.add(jLabel1);
		this.add(jTextField1);
		this.add(jLabel2);
		this.add(jButton1);
		this.add(jButton2);
		jButton2.setVisible(false);
		this.add(jScrollPane1);
		jScrollPane1.getViewport().add(jTextArea1);
		jScrollPane1.setVisible(false);
	}

	// �����ť�¼�
	public void actionPerformed(ActionEvent e) {
		// ��ȡ�û������ѧ��
		String xuehao = jTextField1.getText();
		// ѧ�Ų����ڵĲ�����ɾ�������ز����Ѵ��󣺸�ѧ���Ѿ������ڡ�
		try {
			ResultSet rs1 = st.executeQuery("select * from studentsinfo where xuehao='" + xuehao + "'");
			if (!(rs1.next())) {
				JOptionPane.showMessageDialog(this, "��ѧ�Ų����ڣ��������ɾ����");
				return;
			}
		} catch (Exception ex) {
			// ��������쳣��������Ϣ�Ի�����ʾ���ܲ��룬����ʾ�쳣����Ϣ
			ex.printStackTrace();
		}
		if (e.getSource() == jButton1) {
			// ɾ��֮ǰ��ʾҪɾ����ѧ����Ϣ
			jButton1.setVisible(false);
			jScrollPane1.setVisible(true);
			jButton2.setVisible(true);
			try {
				// ����st����ִ��SQL��䣬���ؽ��������
				ResultSet rs2 = st.executeQuery("select * from studentsinfo where xuehao='" + xuehao + "'");
				// ��������:������ʾ������еļ�¼
				// �˴�û��ʹ��while����Ϊѧ����Ψһ��
				if (rs2.next()) {
					jTextArea1.append("ѧ��:" + rs2.getString("xuehao") + "\n����:" + rs2.getString("xingming") + "\n�Ա�:"
							+ rs2.getString("xingbie") + "\n��������:" + rs2.getDate("dateString")+"\n����:" + rs2.getString("jiguan") + "\n�༶��:" + rs2.getString("ClassId"));
				} else
					JOptionPane.showMessageDialog(this, "û�����ѧ��!");
			} catch (Exception ex) {
				// ������Ϣ�Ի�����ʾ��ѯʧ��
				JOptionPane.showMessageDialog(this, "��ѯʧ��!");
			}
			return;
		}

		// Ҫ���û�ȷ��ɾ��
		// if(JOptionPane.showConfirmDialog(this,"ȷ��Ҫɾ����")==JOptionPane.YES_OPTION)
		else {
			try {
				// ����st����ִ��SQLɾ������
				st.executeUpdate("delete from studentsinfo where xuehao='" + xuehao + "'");
				// ������Ϣ�Ի�����ʾɾ�������ɹ�
				JOptionPane.showMessageDialog(this, "ɾ�������ɹ�!");
				// �������ѧ�ŵ��ı���
				jTextField1.setText("");
				// ÿ��ȷ��ɾ��֮�����ԭ��Ҫɾ����ѧ����Ϣ�������´�ɾ���������ϴ΄h����ѧ����Ϣ
				jTextArea1.setText("");
				jScrollPane1.setVisible(false);
				jButton2.setVisible(false);
				jButton1.setVisible(true);
			} catch (Exception ex) {
				// ������Ϣ�Ի�����ʾ����ɾ��
				JOptionPane.showMessageDialog(this, "ɾ������ִ��ʧ��!");
			}
		}
	}
}
