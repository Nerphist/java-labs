package ua.kpi.tef.ti71.lab6.entity;

import lombok.*;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
public class MathTest extends Test {

    public enum MathSphere{
        Algebra,
        Geometry
    }

    private MathSphere sphere;

    public MathTest(int level, int questionQuantity, MathSphere sphere){
        this.level = level;
        this.questionQuantity = questionQuantity;
        this.sphere = sphere;
    }

}
