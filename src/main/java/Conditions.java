import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="Conditions")
public class Conditions {

    @Id
    @Column(name="idConditions")
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private int idConditions;

    @Column(name = "ConditionsDesc", nullable = false)
    private String ConditionsDesc;

    @Column(name = "ConditionsValue", nullable = false)
    private String ConditionsValue;

    @Column(name = "ConditionCount", nullable = false)
    private int ConditionCount;

    public int getConditionCount() {
        return ConditionCount;
    }

    public void setConditionCount(int conditionCount) {
        ConditionCount = conditionCount;
    }

    public String getConditionsValue() {
        return ConditionsValue;
    }

    public void setConditionsValue(String conditionsValue) {
        ConditionsValue = conditionsValue;
    }

    public int getIdConditions() {
        return idConditions;
    }

    public void setIdConditions(int idConditions) {
        this.idConditions = idConditions;
    }

    public String getConditionsDesc() {
        return ConditionsDesc;
    }

    public void setConditionsDesc(String conditionsDesc) {
        ConditionsDesc = conditionsDesc;
    }

    @Override
    public String toString() {
        return ConditionsDesc+"";
    }
}
