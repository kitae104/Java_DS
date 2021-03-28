package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Info.findAll", query="SELECT i FROM Info i")
public class Info implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idx;

	private int age;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id")
	private User user;

	public Info() {
	}

	public int getIdx() {
		return this.idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}