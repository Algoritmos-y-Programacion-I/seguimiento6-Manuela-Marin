package ui;

import java.util.Scanner;
import model.Fauna;
import model.Flora;
import model.Species;
import model.SpeciesController;

public class SpeciesExecutable {

	private Scanner reader;
	private SpeciesController speciesController;

	public static void main(String[] args) {
		SpeciesExecutable exe = new SpeciesExecutable();
		exe.showMainMenu();
	}

	public SpeciesExecutable() {

		reader = new Scanner(System.in);
		speciesController = new SpeciesController();
	}

	public void showMainMenu() {

		System.out.println("Welcome to Icesi Species");

		boolean stopFlag = false;

		while (!stopFlag) {

			System.out.println("\nType an option");
			System.out.println("1. Register a Species");
			System.out.println("2. Edit a Species");
			System.out.println("3. Delete a Species");
			System.out.println("4. Show a Species");
			System.out.println("0. Exit");

			int mainOption = reader.nextInt();

			switch (mainOption) {

			case 1:
				registerSpecies();
				break;
			case 2:
				editSpecies();
				break;
			case 3:
				deleteSpecies();
				break;
			case 4: 
				showSpecies();
				break;
			case 0:
				System.out.println("Thanks for using our system");
				stopFlag = true;
				break;
			default:
				System.out.println("You must type a valid option");
				break;

			}

		}

	}

	public void registerSpecies() {

		System.out.println("Is this species Flora or Fauna? (1 for Flora, 2 for Fauna): ");
		int type = reader.nextInt();

		System.out.println("Type the new Species' name: ");
		String name = reader.next();

		System.out.println("Type the new Species' scientific name: ");
		String scientificName = reader.next();

		if (type ==1) {
			System.out.println("Does it have flower? (true/false): ");
			reader.nextLine();
			boolean hasFlowers = reader.nextBoolean();

			System.out.println("Does it have fruits? (true/false): ");
			boolean hasFruits = reader.nextBoolean();

			System.out.println("Maxium heigth: ");
			double maxHeight = reader.nextDouble();

			if (speciesController.registerFlora(name, scientificName, hasFlowers, hasFruits, maxHeight)) {
				System.out.println("Flora registered seccessfully");
			}else{
				System.out.println("Error, Flora couldn't be registered");
			}
		}else if (type == 2) {
			System.out.println("Is it migratory? (true/false): ");
			boolean isMigratory = reader.nextBoolean();

			System.out.println("Maxium weigth: ");
			double maxWeight = reader.nextDouble();

			if (speciesController.registerFauna(name, scientificName, isMigratory, maxWeight)) {
				System.out.println("Fauna registered successfully");
			}else {
				System.out.println("Error, Fauna couldn't be registered");
			}
		}
	}

	public void editSpecies() {

		System.out.println("Which Species do you want to delete?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);
			int index = reader.nextInt() -1;
			if (index >= 0 && index < speciesController.species.length && speciesController.species[index] != null) {
            Species selectedSpecies = speciesController.species[index];

				if (selectedSpecies instanceof Flora) {
					Flora flora = (Flora) selectedSpecies;

					System.out.println("Editing Flora species: " + flora.getName());
					System.out.println("Enter new scientific name: ");
					String scientificName = reader.next();
					flora.setScientificName(scientificName);

					System.out.println("Does it have flowers? (true/false): ");
					boolean hasFlowers = reader.nextBoolean();
					flora.setHasFlowers(hasFlowers);

					System.out.println("Does it have fruits? (true/false): ");
					boolean hasFruits = reader.nextBoolean();
					flora.setHasFruits(hasFruits);

					System.out.println("Enter new maximum height: ");
					double maxHeight = reader.nextDouble();
					flora.setMaxHeight(maxHeight);

					System.out.println("Flora species updated successfully.");
				
				} else if (selectedSpecies instanceof Fauna) {
					Fauna fauna = (Fauna) selectedSpecies;

					System.out.println("Editing Fauna species: " + fauna.getName());
					System.out.println("Enter new scientific name: ");
					String scientificName = reader.next();
					fauna.setScientificName(scientificName);

					System.out.println("Is it migratory? (true/false): ");
					boolean isMigratory = reader.nextBoolean();
					fauna.setMigratory(isMigratory);

					System.out.println("Enter new maximum weight: ");
					double maxWeight = reader.nextDouble();
					fauna.setMaxWeight(maxWeight);

					System.out.println("Fauna species updated successfully.");
				}
			} else {
				System.out.println("Invalid species selection.");
			}
		} else {
			System.out.println("There aren't any species registered yet");
		}

	}


	public void deleteSpecies() {
		System.out.println("Which Species do you want to delete?");
		String query = speciesController.showSpeciesList();
	
		if (!query.equals("")) {
			System.out.println(query);
			int index = reader.nextInt() - 1;
	
			if (index >= 0 && index < speciesController.species.length && speciesController.species[index] != null) {
				speciesController.species[index] = null;
				System.out.println("Species deleted successfully.");
			} else {
				System.out.println("Invalid species selection.");
			}
		} else {
			System.out.println("There aren't any species registered yet");
		}
	}

	public void showSpecies() {

		System.out.println("Which Species do you want to review?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);
			int index = reader.nextInt() - 1;

			if (index >= 0 && index < speciesController.species.length && speciesController.species[index] != null) {
				Species selectedSpecies = speciesController.species[index];

				if (selectedSpecies instanceof Flora) {
					Flora flora = (Flora) selectedSpecies;

					System.out.println("Flora Species Details:");
					System.out.println("Name: " + flora.getName());
					System.out.println("Scientific Name: " + flora.getScientificName());
					System.out.println("Has Flowers: " + flora.isHasFlowers());
					System.out.println("Has Fruits: " + flora.isHasFruits());
					System.out.println("Max Height: " + flora.getMaxHeight());
				} else if (selectedSpecies instanceof Fauna) {
					Fauna fauna = (Fauna) selectedSpecies;

					System.out.println("Fauna Species Details:");
					System.out.println("Name: " + fauna.getName());
					System.out.println("Scientific Name: " + fauna.getScientificName());
					System.out.println("Is Migratory: " + fauna.isMigratory());
					System.out.println("Max Weight: " + fauna.getMaxWeight());
				}

			} else {
				System.out.println("Invalid species selection.");
			}
		} else {
			System.out.println("There aren't any species registered yet");
		}

	}
}
