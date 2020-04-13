package com.nilesh.poc.laundry.dao;

import java.util.List;

import com.nilesh.poc.laundry.exception.LaundryException;
import com.nilesh.poc.laundry.pojos.ClothsCategory;
import com.nilesh.poc.laundry.pojos.TypeOfWash;

public interface IAdminDao {

	String addTypeOfWash(TypeOfWash t) throws LaundryException;
	List<ClothsCategory> listClothsCategory() throws LaundryException;;
	
	String addClothCategory(ClothsCategory c) throws LaundryException;;
	List<TypeOfWash> listTypeOfWash() throws LaundryException;;
	
	String deleteCloths(int cloth_id) throws LaundryException;;
	String deleteWash(int tid) throws LaundryException;;
	ClothsCategory getClothsCategory(int cloth_id) throws LaundryException;;
	String updateClothCategory(ClothsCategory c) throws LaundryException;;
	String updateTypeOfWash(TypeOfWash t) throws LaundryException;;
	TypeOfWash getWashRecord(int tid) throws LaundryException;;	

}
