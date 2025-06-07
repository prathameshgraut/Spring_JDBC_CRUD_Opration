package Spring_Demo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MainApp {

	public static void main(String[] args) {
	
		ApplicationContext ref = new AnnotationConfigApplicationContext(Config.class);
		JdbcTemplate JT = ref.getBean(JdbcTemplate.class);

		
		int Id=115;
		String Name="Vivo";
		double Price=27599;
		String Model="V29 Pro";
		String Processor="Snapdragon 512";
//		//insertion operation
		String query="insert into Mobile_Shop values(?,?,?,?,?)";
		int Add = JT.update(query,Id,Name,Price,Model,Processor);
		if(Add>0) {
			System.out.println("Data Added SuccessFully..!!!");
		}else {
			System.out.println("Failed,Data Not Added ");
		}

		
		int Id=114;
		String Processor="Oled HD+";
//		//update opertion
		String Query="update Mobile_Shop set Processor=? where Id=?";
		int Update=JT.update(Query,Processor,Id);
		if(Update>0) {
			System.out.println("Data Updated SuccessFully....");
		}else {
			System.out.println("Due To The Some Error");
		}

		
		int Id=115;
//		//Drop data operation
		String Query="delete from Mobile_Shop where Id=?";
		int del=JT.update(Query,Id);
		if(del>0) {
			System.out.println("Deleted Data SuccessFully!!");
		}else {
			System.out.println("Failed Not Deleted Data");
		}

		
		// Show Operation
		String Query="select * from Mobile_Shop";
		List <Mobile_Shop>list=JT.query(Query, new MobileRowMapper());
		for(Mobile_Shop M1: list) {
			System.out.println("| Id:"+M1.getId()+" | Name:"+M1.getName()+" | Price:"+M1.getPrice()+" | Model:"+M1.getModel()+" | Processor:"+M1.getProcessor());
		}
	}

}
