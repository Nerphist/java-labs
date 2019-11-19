package ua.kpi.tef.ti71.lab6.entity;

import lombok.*;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
public class LanguageTest extends Test {
    private String language;

    public LanguageTest(int level, int questionQuantity, String language){
        this.level = level;
        this.questionQuantity = questionQuantity;
        this.language = language;
    }

}
