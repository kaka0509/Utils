package test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

public class test {
	// JDBC ���������ƺ����ݿ��ַ
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	// ���ݿ������Ϊ EXAMPLE
	static final String DB_URL = "jdbc:mysql://localhost/EXAMPLE";

	// �������ݿ��û���������
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// ע��JDBC����
			Class.forName("com.mysql.jdbc.Driver");

			// ������
			System.out.println("�������ӵ����ݿ⡭��");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// ִ�в�ѯ
			System.out.println("������ѯ��䡭��");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			String sql = "SELECT id, name, age FROM Students";
			ResultSet rs = stmt.executeQuery(sql);

			// �õ��ʹ�������
			while (rs.next()) {
				// ����
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");

				// ��ʾ
				System.out.print("ID: " + id);
				System.out.print(", Age: " + age);
				System.out.print(", Name: " + name);
				System.out.println();
			}

			// ������в�������
			rs.moveToInsertRow();
			rs.updateInt("id", 5);
			rs.updateString("name", "John");
			rs.updateInt("age", 21);
			// �������ݿ�
			rs.insertRow();

			// �����ֳ�
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// ���ر���Դ
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("��ѯ�������ټ�!");
	}
}
