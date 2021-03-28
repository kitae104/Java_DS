package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Info;
import model.User;

public class Main {	
	public static void main(String... args) {	
		
		//FactoryManager를 생성합니다. "JpaExample"은 persistence.xml에 쓰여 있는 이름이다.	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_DS");	
		
		// Manager를 생성한다.	
		EntityManager em = emf.createEntityManager();	
		
		// User 테이블에서 kkt의 아이디를 가져온다.	
		User user = em.find(User.class, "kkt");	
		System.out.println(user.getName());	
		// User테이블에 연결되어 있는 Info테이블의 데이터를 가져온다.	
		List<Info> infos = user.getInfos();	
		for(Info info : infos) {	
			System.out.println(info.getAge());	
		}	
	}	
}

