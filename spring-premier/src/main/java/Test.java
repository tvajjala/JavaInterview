import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trvajjala.spring.aop.Customer;
import com.trvajjala.spring.aop.CustomerService;




public class Test {

	
	public static void main(String[] args) {
		
		
		BeanFactory ctx=new ClassPathXmlApplicationContext("customer-aop.xml");
		
		CustomerService customerService=(CustomerService) ctx.getBean("customerService");
		
		Customer  customer=customerService.getCustomer("ThirupathiReddy", "9000211024");
		
		customerService.addCustomer(customer);
		
		
		
	}
	
}
