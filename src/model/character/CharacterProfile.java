package model.character;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterProfile {
    //original data is string of date
    String birthday;
    String originOfBirth;
}
