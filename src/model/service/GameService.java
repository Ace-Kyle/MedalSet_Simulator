package model.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.ability.Ability;
import model.ability.Affect;
import model.ability.AffectType;
import model.character.Character;
import model.character.CharacterTag;
import model.character.ClassType;
import model.character.ElementType;
import model.medal.Medal;
import model.medal.MedalAffectType;
import model.medal.MedalTag;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class GameService {
    private static GameData gameData;
    private static GameService INSTANCE;

    public static GameService getInstance() throws IOException {
        if (INSTANCE == null) {
            INSTANCE = new GameService();
            INSTANCE.loadGameData("data/game_data.json");
        }
        return INSTANCE;
    }

    /**
     * Loads game data from the specified JSON file
     * @param filePath Path to the JSON file
     * @throws IOException If there's an error reading or parsing the file
     */
    public void loadGameData(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        if (gameData == null) {
            gameData = mapper.readValue(new File(filePath), GameData.class);
            System.out.println("Game data loaded successfully:");
            System.out.println("- " + gameData.getAbility().size() + " abilities");
            System.out.println("- " + gameData.getCharas().size() + " characters");
            System.out.println("- " + gameData.getMedal().size() + " medals");
            System.out.println("- " + gameData.getMedal_tag().size() + " medal tags");
        } else {
            System.out.println("Game data is already loaded!");
        }
    }

    /**
     * Gets a character by ID
     * @param characterId The character ID to search for
     * @return The matching Character or null if not found
     */
    public Character getCharacterById(int characterId) {
        return gameData.getCharas().stream()
                .filter(character -> character.getId() == characterId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets a medal by ID
     * @param medalId The medal ID to search for
     * @return The matching Medal or null if not found
     */
    public Medal getMedalById(int medalId) {
        return gameData.getMedal().stream()
                .filter(medal -> medal.getId() == medalId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets a medal tag by ID
     * @param tagId The tag ID to search for
     * @return The matching MedalTag or null if not found
     */
    public MedalTag getMedalTagById(int tagId) {
        return gameData.getMedal_tag().stream()
                .filter(tag -> tag.getId() == tagId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets an ability by ID
     * @param abilityId The ability ID to search for
     * @return The matching Ability or null if not found
     */
    public Ability getAbilityById(int abilityId) {
        return gameData.getAbility().stream()
                .filter(ability -> ability.getAbility_id() == abilityId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Simulates combining three medals together and returns the activated medal tag sets
     * @param medalId1 First medal ID
     * @param medalId2 Second medal ID
     * @param medalId3 Third medal ID
     * @return A map containing the medal tag combinations and their activated abilities
     */
    public Map<MedalTag, List<Ability>> combineMedals(int medalId1, int medalId2, int medalId3) {
        Medal medal1 = getMedalById(medalId1);
        Medal medal2 = getMedalById(medalId2);
        Medal medal3 = getMedalById(medalId3);

        if (medal1 == null || medal2 == null || medal3 == null) {
            throw new IllegalArgumentException("One or more medals not found!");
        }

        System.out.println("Combining medals: " + medal1.getName() + ", " + medal2.getName() + ", " + medal3.getName());

        // Collect all tag IDs from the medals
        Set<Integer> allTagIds = new HashSet<>();
        allTagIds.addAll(medal1.getTag_ids());
        allTagIds.addAll(medal2.getTag_ids());
        allTagIds.addAll(medal3.getTag_ids());

        // Count occurrences of each tag
        Map<Integer, Integer> tagCounts = new HashMap<>();

        // Count tags from medal1
        for (Integer tagId : medal1.getTag_ids()) {
            tagCounts.put(tagId, tagCounts.getOrDefault(tagId, 0) + 1);
        }

        // Count tags from medal2
        for (Integer tagId : medal2.getTag_ids()) {
            tagCounts.put(tagId, tagCounts.getOrDefault(tagId, 0) + 1);
        }

        // Count tags from medal3
        for (Integer tagId : medal3.getTag_ids()) {
            tagCounts.put(tagId, tagCounts.getOrDefault(tagId, 0) + 1);
        }

        // Find tags that appear in at least 2 medals
        List<Integer> tagsWithTwoOrMore = tagCounts.entrySet().stream()
                .filter(entry -> entry.getValue() >= 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // Map to store results - Medal Tag and associated abilities
        Map<MedalTag, List<Ability>> activatedTagSets = new HashMap<>();

        // Check for tag combinations and their abilities
        for (Integer tagId : tagsWithTwoOrMore) {
            MedalTag medalTag = getMedalTagById(tagId);
            if (medalTag != null) {
                List<Ability> activatedAbilities = new ArrayList<>();

                // For 2 medals with same tag, activate the set2_ability_id
                if (tagCounts.get(tagId) >= 2) {
                    Ability twoSetAbility = getAbilityById(medalTag.getSet2_ability_id());
                    if (twoSetAbility != null) {
                        activatedAbilities.add(twoSetAbility);
                    }
                }

                // For 3 medals with same tag, activate the set3_ability_id
                if (tagCounts.get(tagId) >= 3) {
                    Ability threeSetAbility = getAbilityById(medalTag.getSet3_ability_id());
                    if (threeSetAbility != null) {
                        activatedAbilities.add(threeSetAbility);
                    }
                }

                // Add to result map if we found abilities
                if (!activatedAbilities.isEmpty()) {
                    activatedTagSets.put(medalTag, activatedAbilities);
                }
            }
        }

        // Also add individual medal abilities
        addMedalBaseAbility(medal1, activatedTagSets);
        addMedalBaseAbility(medal2, activatedTagSets);
        addMedalBaseAbility(medal3, activatedTagSets);

        return activatedTagSets;
    }

    /**
     * Helper method to add a medal's base ability to the activated abilities map
     * @param medal The medal to add ability from
     * @param activatedTagSets Map to add the ability to
     */
    private void addMedalBaseAbility(Medal medal, Map<MedalTag, List<Ability>> activatedTagSets) {
        Ability medalAbility = getAbilityById(medal.getAbility_id());
        if (medalAbility != null) {
            // Create a special "Medal Base Ability" tag to distinguish individual medal abilities
            MedalTag medalBaseTag = new MedalTag();
            medalBaseTag.setId(0); // Use 0 to indicate it's not a real tag ID
            medalBaseTag.setName("Medal Base: " + medal.getName());

            List<Ability> abilities = activatedTagSets.getOrDefault(medalBaseTag, new ArrayList<>());
            abilities.add(medalAbility);
            activatedTagSets.put(medalBaseTag, abilities);
        }
    }

    /**
     * Display detailed information about activated medal tag sets and their abilities
     * @param activatedTagSets Map of activated medal tag sets and their abilities
     */
    public void displayMedalSetDetails(Map<MedalTag, List<Ability>> activatedTagSets) {
        System.out.println("\n===== MEDAL SET BONUSES =====");

        for (Map.Entry<MedalTag, List<Ability>> entry : activatedTagSets.entrySet()) {
            MedalTag tag = entry.getKey();
            List<Ability> abilities = entry.getValue();

            System.out.println("\n" + tag.getName() + ":");

            for (Ability ability : abilities) {
                System.out.println("  Ability ID: " + ability.getAbility_id());
                for (Affect affect : ability.getAffects()) {
                    System.out.println("    - " + affect.getDetail());
                }
            }
        }
    }

    /**
     * Get the GameData object
     * @return The loaded game data
     */
    public static GameData getGameData() {
        return gameData;
    }

    //custom
    public ClassType getClassTypeById(int id) {
        return gameData.getRole().stream()
                .filter(role -> role.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public ElementType getElementTypeById(int id) {
        return gameData.getElement().stream()
                .filter(element -> element.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public CharacterTag getCharacterTagById(int id) {
        return gameData.getCharacterTag().stream()
                .filter(tag -> tag.getId() == id)
                .findFirst()
                .orElse(null);
    }
    //FIXME - remove implement affectType because cannot found affect_type
    //in crawl data
    public AffectType getAffectTypeById(int id){
        return null;
    }
    public MedalAffectType getMedalAffectTypeById(int id){
        return gameData.getMedalAffectType().stream()
                .filter(type -> type.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public MedalAffectType getMedalAffectTypeByName(String name){
        return gameData.getMedalAffectType().stream()
                .filter(type -> type.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public boolean isMedalAffectTypeNameHasId(String name, int id){
        long found = gameData.getMedalAffectType().stream()
                .filter(type ->
                        type.getName().equalsIgnoreCase(name) &&
                        Arrays.asList(type.getType_ids()).contains(id))
                .count();
        return found >= 1;
    }


}
