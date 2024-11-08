package model;

public class SpeciesController {

	public Species[] species;

	public SpeciesController() {

		this.species = new Species[80];

	}

	public boolean registerFlora(String name, String scientificName, boolean hasFlowers, boolean hasFruits, double maxHeight) {

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = new Flora(name, scientificName, hasFlowers, hasFruits, maxHeight);
				return true;
			}

		}

		return false;

	}

	public boolean registerFauna(String name, String scientificName, boolean isMigratory, double maxWeight) {

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = new Fauna(name, scientificName, isMigratory, maxWeight);
				return true;
			}

		}

		return false;

	}

	public boolean editSpecies (int index, Species newSpeciesData){
		if (index >= 0 && index < species.length && species[index] != null) {
			species[index] = newSpeciesData;
			return true;
		}
		return false;
	}

	public boolean deleteSpecies (int index) {
		if (index >= 0 && index < species.length && species[index] != null) {
			species[index] = null; 
			return true;
		}
		return false;
	}

	public String showSpeciesList() {

		String msg = "";

		for (int i = 0; (i < species.length); i++) {
			if (species[i] != null) {
				msg += "\n" + (i + 1) + ". " + species[i].getName();
			}
		}

		return msg;

	}

}
