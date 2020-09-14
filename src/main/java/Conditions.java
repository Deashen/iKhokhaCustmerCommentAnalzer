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

    @Column(name = "ConditionsLogic", nullable = false)
    private String ConditionsLogic;

    @Column(name = "ConditionsValue", nullable = false)
    private String ConditionsValue;

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

    public String getConditionsLogic() {
        return ConditionsLogic;
    }

    public void setConditionsLogic(String conditionsLogic) {
        ConditionsLogic = conditionsLogic;
    }
}
