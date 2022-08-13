package api.pet;

import java.util.concurrent.ThreadLocalRandom;

public class Data {

    public static int getPetId() {
        return petId;
    }

    public int setPetId() {
        petId = ThreadLocalRandom.current().nextInt(10, 99999);
        System.out.println("Current petId is: " + petId);
        return petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String name;
    private String status;
    private static int petId;
}
