package co.edu.unbosque.model.service;

import co.edu.unbosque.model.dao.PlayerDAO;
import co.edu.unbosque.model.entity.Player;
import co.edu.unbosque.util.MyLinkedList;

public class PlayerService implements Service<Player, Integer>{
	
	private PlayerDAO playerdao;
	
	public PlayerService() {
		this.playerdao = new PlayerDAO();
	}

	@Override
	public void create(Player objeto) {
		playerdao.saveOrUpdate(objeto);
	}

	@Override
	public void update(Player objeto) {
		playerdao.saveOrUpdate(objeto);
	}

	@Override
	public Player delete(Player objeto) {
		playerdao.delete(objeto);
		return objeto;
	}

	@Override
	public Player findById(Integer id) {
		return playerdao.get(id);
	}

	@Override
	public MyLinkedList<Player> findAll() {
		return playerdao.findAll();
	}
	
	

}
