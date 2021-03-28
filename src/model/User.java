package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	//bi-directional many-to-one association to Info
	@OneToMany(mappedBy="user")
	private List<Info> infos;

	public User() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Info> getInfos() {
		return this.infos;
	}

	public void setInfos(List<Info> infos) {
		this.infos = infos;
	}

	public Info addInfo(Info info) {
		getInfos().add(info);
		info.setUser(this);

		return info;
	}

	public Info removeInfo(Info info) {
		getInfos().remove(info);
		info.setUser(null);

		return info;
	}

}