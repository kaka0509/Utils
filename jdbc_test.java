package test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

public class test {
	// JDBC 驱动器名称和数据库地址
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	// 数据库的名称为 EXAMPLE
	static final String DB_URL = "jdbc:mysql://localhost/EXAMPLE";

	// 创建数据库用户名和密码
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 注册JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");

			// 打开连接
			System.out.println("正在连接到数据库……");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// 执行查询
			System.out.println("创建查询语句……");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			String sql = "SELECT id, name, age FROM Students";
			ResultSet rs = stmt.executeQuery(sql);

			// 得到和处理结果集
			while (rs.next()) {
				// 检索
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");

				// 显示
				System.out.print("ID: " + id);
				System.out.print(", Age: " + age);
				System.out.print(", Name: " + name);
				System.out.println();
			}

			// 结果集中插入新行
			rs.moveToInsertRow();
			rs.updateInt("id", 5);
			rs.updateString("name", "John");
			rs.updateInt("age", 21);
			// 更新数据库
			rs.insertRow();

			// 清理现场
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// 检查关闭资源
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
		System.out.println("查询结束，再见!");
	}
}
