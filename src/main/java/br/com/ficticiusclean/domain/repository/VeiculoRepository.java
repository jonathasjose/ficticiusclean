package br.com.ficticiusclean.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ficticiusclean.domain.model.Veiculo;

@Repository
public class VeiculoRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public Veiculo salvar(Veiculo veiculo) {	
		entityManager.persist(veiculo);
		return veiculo;
	}
	
	@Transactional
	public Veiculo atualizar(Veiculo veiculo) {	
		return entityManager.merge(veiculo);
	}
	
	public List<Veiculo> buscarTodos() {	
		
		StringBuffer hql = new StringBuffer();
		hql.append("SELECT v FROM Veiculo v");
		TypedQuery<Veiculo> query = entityManager.createQuery(hql.toString(), Veiculo.class);
		
		return query.getResultList();
	}

}
