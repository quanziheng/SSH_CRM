package cn.itcast.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Customer;
import cn.itcast.entity.User;
import cn.itcast.entity.Visit;
import cn.itcast.service.CustomerService;
import cn.itcast.service.UserService;
import cn.itcast.service.VisitService;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{

	private VisitService visitService;
	private Visit visit = new Visit();
	
	@Override
	public Visit getModel() {
		// TODO Auto-generated method stub
		return visit;
	}
	public VisitService getVisitService() {
		return visitService;
	}

	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}
	
	private CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	//3拜访列表方法
	public String list(){
		
		List<Visit> list = visitService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	//2新增方法
	public String addVisit(){
		
		visitService.addVisit(visit);
		return "addVisit";
	}

	//1到新增页面
	public String toAddPage(){
		
		//查询所有的用户
		List<User> listUser = userService.findAll();
		
		//查询所有的客户
		List<Customer> listCustomer = customerService.findAll();
		
		//放到域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listCustomer", listCustomer );
		request.setAttribute("listUser", listUser );
		return "toAddPage";
	}

	
}
