package spring.tp4.dao;

import org.springframework.data.repository.CrudRepository;
import spring.tp4.model.People;

import javax.transaction.Transactional;
import java.util.List;

public interface IPeopleDAO extends CrudRepository<People,Integer> {

    /**
     * Recupère tous les people
     * @return liste de tous les people
     */
    List<People> findAll();

    /**
     * recupère un people
     * @param id id du people à récupérer
     * @return le people dont l'id est égale au paramètre @id
     */
    People findBy_id(int id);

    boolean existsBy_id(Integer integer);

    /**
     * sauvegarde un changement en remplaçant
     * @param people people à sauvegarder
     */
    People save(People people);

    /**
     * supprime un people
     * @param id id du people à supprimer
     */
    @Transactional
    void deleteBy_id(int id);

}
