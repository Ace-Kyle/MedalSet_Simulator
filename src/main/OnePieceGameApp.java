package main;

import model.Ability;
import model.Character;
import model.Medal;
import model.MedalTag;
import model.OnePieceGameService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OnePieceGameApp {
    public static void main(String[] args) {
        OnePieceGameService gameService = new OnePieceGameService();

        try {
            // Load game data
            System.out.println("Loading ONE PIECE game data...");
            gameService.loadGameData("data/game_data.json"); // Adjust path as needed

            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\n===== ONE PIECE Game Simulator =====");
                System.out.println("1. View all medals");
                System.out.println("2. View all characters");
                System.out.println("3. Combine medals");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        displayAllMedals(gameService);
                        break;
                    case 2:
                        displayAllCharacters(gameService);
                        break;
                    case 3:
                        combineMedals(gameService, scanner);
                        break;
                    case 4:
                        running = false;
                        System.out.println("Thank you for using ONE PIECE Game Simulator!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

            scanner.close();

        } catch (IOException e) {
            System.err.println("Error loading game data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void displayAllMedals(OnePieceGameService gameService) {
        List<Medal> medals = gameService.getGameData().getMedal();

        System.out.println("\n===== All Available Medals =====");
        System.out.println("ID\tName");
        System.out.println("---------------------------");

        for (Medal medal : medals) {
            System.out.println(medal.getMedal_id() + "\t" + medal.getName());
        }
    }

    private static void displayAllCharacters(OnePieceGameService gameService) {
        List<model.Character> characters = gameService.getGameData().getCharacter();

        System.out.println("\n===== All Available Characters =====");
        System.out.println("ID\t\tName\t\tNickname");
        System.out.println("--------------------------------------------------");

        for (Character character : characters) {
            System.out.println(character.getChara_id() + "\t" + character.getName() + "\t\t" + character.getNickname());
        }
    }

    private static void combineMedals(OnePieceGameService gameService, Scanner scanner) {
        try {
            // Display available medals to help user choose
            displayAllMedals(gameService);

            System.out.print("\nEnter first medal ID: ");
            int medal1Id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter second medal ID: ");
            int medal2Id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter third medal ID: ");
            int medal3Id = Integer.parseInt(scanner.nextLine());

            // Combine medals and display results
            Map<MedalTag, List<Ability>> activatedTagSets = gameService.combineMedals(medal1Id, medal2Id, medal3Id);
            gameService.displayMedalSetDetails(activatedTagSets);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid medal ID.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}