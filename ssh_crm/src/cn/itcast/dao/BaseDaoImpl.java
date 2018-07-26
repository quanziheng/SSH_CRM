package cn.itcast.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class pClass;
	//构造方法
	public BaseDaoImpl(){
		
		//第一步：得到当前运行类Class
		Class clazz = this.getClass();
		//System.out.println("**********"+clazz);
		
		//第二步：得到运行类父类的参数化类型BaseDaoImpl<Customer>
		//Type  getGenericSuperclass()
		
		Type type = clazz.getGenericSuperclass();
		
		//使用Type子接口ParameterizedType
		ParameterizedType ptype = (ParameterizedType) type;
		//System.out.println("******"+ptype);
		
		//第三步 得到实际类型参数<Customer>里面的Customer
		//Type[] getActualTypeArguments()
		Type[] types = ptype.getActualTypeArguments();
		//Type接口的实现类就是Class
		Class tclass = (Class)types[0];
		//System.out.println("*****"+pclass);
		this.pClass = tclass;
	}
	
	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findOne(int id) {
		// TODO Auto-generated method stub
		//不能写T.class
		//this.getHibernateTemplate().get(T.class,id);
		
		return (T) this.getHibernateTemplate().get(pClass,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		
		//不能写成这样this.getHibernateTemplate().find("from"+T)
		return (List<T>) this.getHibernateTemplate().find("from "+pClass.getSimpleName());
	}

}
