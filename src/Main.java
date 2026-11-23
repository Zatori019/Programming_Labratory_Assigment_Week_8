public class Main {
    public static void main(String[] args) {
        Team myTeam = new Team();

        Warrior himmel = new Warrior("Himmel", 90, 2000, 50);
        Warrior heisen = new Warrior("Heisen", 70, 3000, 80);
        Mage frieren = new Mage("Frieren", 100, 1000, 200);
        Healer heiter = new Healer("Heiter", 80, 500, 400);

        myTeam.addCharacter(himmel);
        myTeam.addCharacter(heisen);
        myTeam.addCharacter(frieren);
        myTeam.addCharacter(heiter);

        Mage demonLord = new Mage("The Demon Lord", 100, 10000, 2000);

        System.out.println("\n================= ROUND 1 =================\n");

        himmel.attack(demonLord);
        heisen.attack(demonLord);
        frieren.attack(demonLord);
        demonLord.attack(heisen);
        myTeam.healTeam();

        System.out.println("\n================= ROUND 2 =================\n");

        himmel.attack(demonLord);
        heisen.attack(demonLord);
        frieren.attack(demonLord);
        demonLord.attack(himmel);
        myTeam.healTeam();

        myTeam.displayTeam();
        myTeam.removeCharacter(heisen);

        System.out.println("-------------------- INVALID INPUT TESTING --------------------");

        Mage fern = new Mage("Fern", 200, 1000, 200);

        Warrior himmel1 = new Warrior("Himmel", 70, 1000, 100);
        myTeam.addCharacter(himmel1);
    }
}