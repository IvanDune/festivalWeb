package festivalWeb.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum SystemTtrpg {
    DUNGEONS_AND_DRAGONS_5_E ("Dungeons and Dragons 5e"),
    SPIRE_THE_CITY_MUST_FALL ("Spire: The City Must Fall"),
    VAMPIRE_THE_MASQUERADE_5_E ("Vampire The Masquerade 5e");
    private final String title;
}
