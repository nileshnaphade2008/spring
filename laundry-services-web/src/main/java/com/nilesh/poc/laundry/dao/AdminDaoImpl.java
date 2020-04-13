package com.nilesh.poc.laundry.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nilesh.poc.laundry.exception.LaundryException;
import com.nilesh.poc.laundry.pojos.ClothsCategory;
import com.nilesh.poc.laundry.pojos.TypeOfWash;

@Repository
@Transactional
public class AdminDaoImpl implements IAdminDao {
	private final static Logger LOG = LoggerFactory.getLogger(AdminDaoImpl.class);
	@Autowired
	private SessionFactory sf;

	public String addTypeOfWash(TypeOfWash t) throws LaundryException {
		try {
			sf.getCurrentSession().persist(t);
		} catch (Exception exe) {
			LOG.error("Exception while adding type of wash details  :: " + exe.getMessage());
			throw new LaundryException(exe.getMessage());
		}
		return "done";

	}

	public String updateTypeOfWash(TypeOfWash t) throws LaundryException {
		try {
			sf.getCurrentSession().update(t);
		} catch (Exception exe) {
			LOG.error("Exception while updating  type of wash details  :: " + exe.getMessage());
			throw new LaundryException(exe.getMessage());
		}
		return "done";

	}

	public List<ClothsCategory> listClothsCategory() throws LaundryException {
		String jpql = "select c from ClothsCategory c ";
		List<ClothsCategory> array = new ArrayList<ClothsCategory>();
		try {
			array = sf.getCurrentSession().createQuery(jpql, ClothsCategory.class).getResultList();
		} catch (Exception exe) {
			LOG.error("Exception while getting the list of cloth details  :: " + exe.getMessage());
			throw new LaundryException(exe.getMessage());
		}
		return array;
	}

	public ClothsCategory getClothsCategory(int cloth_id) throws LaundryException {
		String jpql = "select c from ClothsCategory c where cloth_id=" + cloth_id;
		ClothsCategory clothCategorry = new ClothsCategory();
		try {
			clothCategorry = (ClothsCategory) sf.getCurrentSession().createQuery(jpql, ClothsCategory.class)
					.getSingleResult();
		} catch (Exception exe) {
			LOG.error("Exception while getting the cloth category details  :: " + exe.getMessage());
			throw new LaundryException(exe.getMessage());
		}
		/// System.out.println(array);
		return clothCategorry;
	}

	public String addClothCategory(ClothsCategory c) throws LaundryException {
		try {
			sf.getCurrentSession().persist(c);
			// System.out.println();
		} catch (Exception exe) {
			LOG.error("Exception while adding  the cloth category details  :: " + exe.getMessage());
			throw new LaundryException(exe.getMessage());
		}
		return "done";
	}

	public String updateClothCategory(ClothsCategory c) throws LaundryException {
		try {
			sf.getCurrentSession().update(c);
			// System.out.println();
		} catch (Exception exe) {
			LOG.error("Exception while updating the cloth category details  :: " + exe.getMessage());
			throw new LaundryException(exe.getMessage());
		}
		return "done";
	}

	public List<TypeOfWash> listTypeOfWash() throws LaundryException {
		String jpql = "select t from TypeOfWash t";
		List<TypeOfWash> array = new ArrayList<TypeOfWash>();
		try {
			array = sf.getCurrentSession().createQuery(jpql, TypeOfWash.class).getResultList();
		} catch (Exception exe) {
			LOG.error("Exception while getting the list type of wash details  :: " + exe.getMessage());
			throw new LaundryException(exe.getMessage());
		}
		return array;

	}

	public String deleteCloths(int cloth_id) throws LaundryException {
		Session hs = sf.getCurrentSession();
		ClothsCategory c = hs.get(ClothsCategory.class, cloth_id);
		try {
			if (c != null) {
				hs.delete(c);
				return "Cloth deatils deleted for id:" + c.getCloth_id();
			}
		} catch (Exception exe) {
			LOG.error("Exception while deleting the cloth details  :: " + exe.getMessage());
			throw new LaundryException(exe.getMessage());
		}
		return "Deletion ofCloths Details is Denied.... invalid details";
	}

	public String deleteWash(int tid) throws LaundryException {
		Session hs = sf.getCurrentSession();

		TypeOfWash t = hs.get(TypeOfWash.class, tid);
		try {
			if (t != null) {
				hs.delete(t);
				return "Type of Wash deatils deleted for id:" + t.getTid();
			}
		} catch (Exception exe) {
			LOG.error("Exception while deleting the wash details  :: " + exe.getMessage());
			throw new LaundryException(exe.getMessage());
		}
		return "Deletion of Wash  Details is Denied.... invalid details";
	}

	public TypeOfWash getWashRecord(int tid) throws LaundryException {
		String jpql = "select c from TypeOfWash c where tid=" + tid;
		TypeOfWash typeOfWas = new TypeOfWash();
		try {
			typeOfWas = (TypeOfWash) sf.getCurrentSession().createQuery(jpql, TypeOfWash.class).getSingleResult();
		} catch (Exception exe) {
			LOG.error("Exception while getting  the wash details  :: " + exe.getMessage());
			throw new LaundryException(exe.getMessage());
		}
		/// System.out.println(array);
		return typeOfWas;
	}

}
