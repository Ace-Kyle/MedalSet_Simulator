package test;

import model.*;
import model.character.Character;
import model.medal.Medal;
import model.medal.MedalTag;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GameServiceTest {
    private GameService gameService;

    @Before
    public void setUp() throws IOException {
        gameService = new GameService();
        gameService.loadGameData("src/test/resources/game_data.json");
    }

    @Test
    public void testGameDataLoaded() {
        GameData gameData = gameService.getGameData();
        Assert.assertNotNull("Game data should not be null", gameData);
        Assert.assertFalse("Ability list should not be empty", gameData.getAbility().isEmpty());
        Assert.assertFalse("Character list should not be empty", gameData.getCharas().isEmpty());
        Assert.assertFalse("Medal list should not be empty", gameData.getMedal().isEmpty());
        Assert.assertFalse("Medal tag list should not be empty", gameData.getMedal_tag().isEmpty());
    }

    @Test
    public void testGetCharacterById() {
        Character luffy = gameService.getCharacterById(400000001);
        Assert.assertNotNull("Should find Luffy character", luffy);
        Assert.assertEquals("Character name should match", "Monkey D. Luffy", luffy.getName());
    }

    @Test
    public void testGetMedalById() {
        Medal luffyMedal = gameService.getMedalById(310100001);
        Assert.assertNotNull("Should find Luffy medal", luffyMedal);
        Assert.assertEquals("Medal name should match", "Luffy Medal", luffyMedal.getName());
    }

    @Test
    public void testCombineMedals() {
        // Test with the East Blue medal set (Luffy, Zoro, Usopp medals)
        Map<MedalTag, List<Ability>> activatedSets = gameService.combineMedals(310100001, 310100002, 310100003);
        Assert.assertFalse("Should have activated some medal sets", activatedSets.isEmpty());

        // Check if East Blue tag is activated (tag_id = 1)
        boolean hasEastBlueTag = activatedSets.keySet().stream()
                .anyMatch(tag -> tag.getName().equals("East Blue"));
        Assert.assertTrue("Should activate East Blue tag set", hasEastBlueTag);
    }
}
