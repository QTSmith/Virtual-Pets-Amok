package VPAmok;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {

		VirtualPetShelter shelter = new VirtualPetShelter();
		Scanner input = new Scanner(System.in);

		OrganicPet molly = new OrgDog("Molly", "Shih-Tzu");
		shelter.intake(molly);
		RoboticPet bolt = new RoboDog("Bolt", "A robotic dog");
		shelter.intake(bolt);
		OrganicPet szoke = new OrgCat("Szoke", "Savannah");
		shelter.intake(szoke);
		RoboticPet nutz = new RoboCat("Nutz", "A robotic cat");
		shelter.intake(nutz);

		boolean quit = false;

		do {
			if (shelter.getLitterBox() >= 100) {
				System.out.println("Eww... The litterbox is super gross! Let's clean it!");
				for (OrganicPet currentPet : shelter.organicCats()) {
					((OrgCat) currentPet).decreaseHealth();
				}
			}
				for (OrganicPet currentPet : shelter.organicDogs()) {
					if (((OrgDog) currentPet).getCageMessiness() >= 100) {
						System.out.println("Let's clean " + currentPet + "'s cage! It's too dirty!");
					((OrgDog) currentPet).decreaseHealth();
					}
				}

			writeLine("\nWe are so happy you're here to help us with our amazing pets!");
			writeLine("\nThis is the current status of our pets:: ");
			writeLine("\nName\t|Mood\t|Health\t|Hunger\t|Thirst\t|OilLvl\t|CageMess");
			writeLine("--------|-------|-------|-------|-------|-------|-------");

			for (OrganicPet currentPet : shelter.organicCats()) {
				writeLine(currentPet.getName() + "\t|" + ((VirtualPet) currentPet).getMood() + "\t|"
						+ ((VirtualPet) currentPet).getHealth() + "\t|" + currentPet.getHunger() + "\t|"
						+ currentPet.getThirst() + "\t|" + " N/A" + "\t|" + " N/A");
			}
			for (OrganicPet currentPet : shelter.organicDogs()) {
				writeLine(currentPet.getName() + "\t|" + ((VirtualPet) currentPet).getMood() + "\t|"
						+ ((VirtualPet) currentPet).getHealth() + "\t|" + currentPet.getHunger() + "\t|"
						+ currentPet.getThirst() + "\t|" + " N/A" + "\t|" + ((OrgDog) currentPet).getCageMessiness());
			}
			for (RoboticPet currentPet : shelter.roboticDogs()) {
				writeLine(currentPet.getName() + "\t|" + ((VirtualPet) currentPet).getMood() + "\t|"
						+ ((VirtualPet) currentPet).getHealth() + "\t|" + "N/A" + "\t|" + "N/A" + "\t|"
						+ currentPet.getOilLevel() + "\t|" + "N/A");
			}
			for (RoboticPet currentPet : shelter.roboticCats()) {
				writeLine(currentPet.getName() + "\t|" + ((VirtualPet) currentPet).getMood() + "\t|"
						+ ((VirtualPet) currentPet).getHealth() + "\t|" + "N/A" + "\t|" + "N/A" + "\t|"
						+ currentPet.getOilLevel() + "\t|" + "N/A");
			}
			System.out.println("The cucrrent level of the litterbox is: " + shelter.getLitterBox());
			writeLine("\nWhat would you like to do next?");
			writeLine(
					"\n1.Feed the organic pets \n2.Water the organic pets \n3.Play with a pet \n4.Adopt a pet \n5.Admit a pet \n6.Clean Cages \n7.Clean Litterbox \n8.Walk Dogs \n9.Maintain all RoboPets \n10.Do nothing \n11.Quit");
			String response = input.nextLine();

			switch (response) {
			case "1":
				shelter.feedAllOrganic();
				System.out.println("Nom, nom, nom.... You fed all of the organic pets!");
				break;
			case "2":
				shelter.waterAllOrganic();
				System.out.println("Slurrrp..Sluuurrpp..You gave water to all of the organic pets!");
				break;
			case "3": // play
				writeLine("The pets all love to play! Which one would you like to play with?:\n");
				displayPets(shelter);
				writeLine("\nPlease type the name of the pet you'd like to play with");
				String petName = input.nextLine();
				shelter.playOne(shelter.getPet(petName));
				writeLine("Ha ha ha! " + petName + "had so much fun with you!  ");
				break;
			case "4": //adopt
				writeLine("We're so pleased you're going to adopt one of our wonderful pets!:\n");
				displayPets(shelter);
				writeLine("\nWhich pet would you like to adopt?");
				String nameToAdopt = input.nextLine();
				VirtualPet x = shelter.getPet(nameToAdopt);
				shelter.adoptPet(x);
				writeLine("We are going to miss " + nameToAdopt + "! But we know yu are going to give them a safe and happy home!");
				break;
			case "5"://intake
				System.out.println("There is always room for a pet in need here! Is it organic an robotic pet?");
				String response2 = input.nextLine();
				if (response2.equalsIgnoreCase("organic")) {
					System.out.println("Great! Is the organic pet a cat or a dog?");
					String response3 = input.nextLine();
					if (response3.equalsIgnoreCase("dog")) {
						System.out.println("Ok! What is the dog's name?");
						String name = input.nextLine();
						System.out.println("Got it! Please enter a brief description of the dog.");
						String description = input.nextLine();
						OrganicPet d = new OrgDog(name, description);
						shelter.intake(d);
					} else if (response3.equalsIgnoreCase("cat")) {
						System.out.println("Ok! What is the cat's name?");
						String name = input.nextLine();
						System.out.println("Got it! Please enter a brief description of the cat.");
						String description = input.nextLine();
						OrganicPet c = new OrgCat(name, description);
						shelter.intake(c);
					}

				} else if (response2.equalsIgnoreCase("robotic")) {
					System.out.println("Great! Is your robotic pet a cat or a dog?");
					String response3 = input.nextLine();

					if (response3.equalsIgnoreCase("dog")) {
						System.out.println("Ok! What is the dog's name?");
						String name = input.nextLine();
						System.out.println("Got it! Please enter a brief description of the dog.");
						String description = input.nextLine();
						RoboticPet d = new RoboDog(name, description);
						shelter.intake(d);
					} else if (response3.equalsIgnoreCase("cat")) {
						System.out.println("Great! What is the cat's name?");
						String name = input.nextLine();
						System.out.println("Got it! Please enter a brief description of the cat.");
						String description = input.nextLine();
						RoboticPet c = new RoboCat(name, description);
						shelter.intake(c);
					}
				}
				break;
			case "6":
				shelter.cleanDogCages();
				System.out.println("All of the dog cages are noe clean!");
				break;
			case "7":
				shelter.cleanLitterBox();
				System.out.println("The litter box has been cleaned!");
				break;
			case "8":
				shelter.walkDogs();
				System.out.println("Phew! All the dogs have been walked!");
				break;
			case "9":
				shelter.maintainAllRobo();
				System.out.println("You maintained all of the robotic pets! All it took was a little elbow grease!");
				break;
			case "10":
				// tick
				break;
			case "11":
				writeLine("Awww... We're sad to see you go! All of our wonderful pets will be waiting on you to return!");
				System.exit(0);
			default:
				writeLine("You've entered an invalid selection. Please try again!");
				break;

			}
			 shelter.tickAllPets();

		}while(!quit);input.close();

	}

	private static void displayPets(VirtualPetShelter shelter) {
		for (VirtualPet currentPet : shelter.pets()) {
			System.out.println(currentPet);
		}
	}

	public static void writeLine(String message) {
		System.out.println(message);
	}
}