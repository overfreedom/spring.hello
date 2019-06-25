package spring.beans.dbproperties;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beansDBProperties.xml");
		DataSource ds = (DataSource) ctx.getBean("datasource");
		System.out.println(ds.getConnection());
		
	}

}
