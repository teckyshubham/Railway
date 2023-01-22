package railway.com.example.RailwayAndMeal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import railway.com.example.RailwayAndMeal.Entity.meal;
import railway.com.example.RailwayAndMeal.Entity.railway;
import railway.com.example.RailwayAndMeal.RestTemplate.communicator;


@Service
public class RailwayService {



	public HashMap<Long,railway> list1;
	public List<railway> list;


	public RailwayService() {
		list1=new HashMap<>();
		list=new ArrayList<>();
		list.add(new railway(1,"Shubham",5,584983,"S-63"));
		list.add(new railway(2,"Ivan",5,52988,"S-62"));
		list1.put((long) 1, new railway(1,"Shubham",5,584983,"S-63"));
		list1.put((long) 2,new railway(2,"Ivan",5,52988,"S-62"));

	}


	public List<railway> getTicket() {
		// TODO Auto-generated method stub
		return list;
	}


	public railway getTicket(long id) {
		if(!list1.containsKey(id)) {
			System.out.print("ID Does not exist ");
			return null;
		}
		railway ans=null;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).id==id) {
				ans=list.get(i);
			}
		}
		// TODO Auto-generated method stub
		return list1.get(id);
	}

	public void addTicket(railway todo) {
		long id=todo.id;
		if(list1.containsKey(id)) {
			System.out.print("ID already exist");
			return ;
		}
		list.add(todo);
		list1.put(todo.id,todo);
		// TODO Auto-generated method stub

	}

	public void deleteTicket(long id) {

		if(!list1.containsKey(id)) {
			System.out.print("ID Does not exist for deletion");
			return;
		}
		for(int i=0;i<list.size();i++) {
			if(list.get(i).id==id) {
				list.remove(i);
				return;
			}
		}
		list1.remove(id);
		// TODO Auto-generated method stub

	}


	public void updateTicket(railway topic, long id) {
		if(!list1.containsKey(id)) {
			System.out.print("ID Does not exist");
			addTicket(topic);
			return;
		}
		for(int i=0;i<list.size();i++) {
			if(list.get(i).id==id) {
				list.remove(i);
				list1.remove(id);
				list.add(i, topic);	
				list1.put(topic.id, topic);
				return;
			}
		}
		// TODO Auto-generated method stub

	}

}
