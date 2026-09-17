class House {
    private int walls;
    private int doors;
    private int windows;
    private String roof;
    private boolean garage;
    private boolean garden;

    private House(HouseBuilder builder) {
        this.walls = builder.walls;
        this.doors = builder.doors;
        this.windows = builder.windows;
        this.roof = builder.roof;
        this.garage = builder.garage;
        this.garden = builder.garden;
    }

    @Override 
    public String toString() {
        return "House with " + walls + " walls, " + doors + " doors, " + windows + " windows, " + roof + " roof" + (garage ? ", a garage": "") + (garden ? ", and a garden": "");
    }

    public static class HouseBuilder {
        private int walls;
        private int doors;
        private int windows;
        private String roof;
        private boolean garage;
        private boolean garden;

        public HouseBuilder setWalls(int walls) {
            this.walls = walls;
            return this;
        }
        public HouseBuilder setDoors(int doors) {
            this.doors = doors;
            return this;
        }
        public HouseBuilder setWindows(int windows) {
            this.windows = windows;
            return this;
        }
        public HouseBuilder setRoof(String roof) {
            this.roof = roof;
            return this;
        }
        public HouseBuilder addGarage() {
            this.garage=true;
            return this;
        }
        public HouseBuilder addGarden() {
            this.garden=true;
            return this;
        }
        public House build() {
            return new House(this);
        }
    }
}

public class BDP {
    public static void main(String[] args) {
        House simpHouse = new House.HouseBuilder()
                .setWalls(4)
                .setDoors(2)
                .setWindows(4)
                .setRoof("Gable")
                .build();
        System.out.println(simpHouse);

        House luxuryHouse = new House.HouseBuilder()
                 .setWalls(6)
                 .setDoors(3)
                 .setWindows(8)
                 .setRoof("Hip")
                 .addGarage()
                 .addGarden()
                 .build();
        System.out.println(luxuryHouse);
    }
}
