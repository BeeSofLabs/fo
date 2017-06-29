package core.dao.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ary on 6/24/17.
 */

public class Order extends RealmObject {
    @PrimaryKey
    private int id;
    private String person;
    private String personUrl;
    private String location;
    private String status;
    private int foodNum;
    private int drinkNum;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerson() {
        return this.person;
    }

    public void setPerson(String ownerName) {
        this.person = ownerName;
    }

    public String getPersonUrl() {
        return this.personUrl;
    }

    public void setPersonUrl(String personUrl) {
        this.personUrl = personUrl;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String ownerLocation) {
        this.location = ownerLocation;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFoodNum() {
        return this.foodNum;
    }

    public void setFoodNum(int foodNum) {
        this.foodNum = foodNum;
    }

    public int getDrinkNum() {
        return this.drinkNum;
    }

    public void setDrinkNum(int drinkNum) {
        this.drinkNum = drinkNum;
    }
}
